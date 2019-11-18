package AutomationTest.WorkingElements;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithHTML5video {

	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/html5video.html");
	}

	@Test
	public void TestHTML5Video() throws InterruptedException
	{
		WebElement videoplayer = driver.findElement(By.id("vplayer"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String source = (String) js.executeScript("return arguments[0].currentSrc", videoplayer);
		long duration = (Long) js.executeScript("return arguments[0].duration", videoplayer);

		assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		assertEquals(25, duration);

		js.executeScript("return arguments[0].play()", videoplayer);
		Thread.sleep(6000);
		js.executeScript("return arguments[0].pause()", videoplayer);

	}


	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
