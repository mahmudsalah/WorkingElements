package AutomationTest.WorkingElements;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTakeScreenshot {
	
ChromeDriver driver;
	
	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.com");
	}
	
	
	@Test
	public void ScreenShotTest() {
		
		WebElement Test = driver.findElement(By.xpath("//*[@id=\"nav-orders\"]/span[2]"));
		Test.click();
		WebElement Username = driver.findElement(By.id("ap_email"));
		WebElement Password = driver.findElement(By.id("ap_password"));
		WebElement bnt = driver.findElement(By.id("signInSubmit"));
		Username.sendKeys("mahmoudsalah");
		Password.sendKeys("01234567");
		bnt.click();
		//Assert.assertEquals("https://www.amazon.com/ap/signin", "TEST");
	}
	
	@AfterMethod
	public void TakeScreenShotTest(ITestResult Result) throws IOException {
		
		if(ITestResult.FAILURE ==Result.getStatus())
		{
			TakesScreenshot TS = (TakesScreenshot) driver;
			File Source = TS.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Source, new File ("./ScreenShot/" + Result.getName() + ".png"));
		}
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
