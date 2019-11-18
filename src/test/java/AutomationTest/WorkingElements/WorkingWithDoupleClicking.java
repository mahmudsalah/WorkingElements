package AutomationTest.WorkingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDoupleClicking {
	
	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

	}

	@Test
	public void DoupleClickingTest() {

		WebElement message = driver.findElement(By.id("message"));
		Actions Builder = new Actions(driver);
		
		Builder.doubleClick(message).perform();
		
	}

	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}

}
