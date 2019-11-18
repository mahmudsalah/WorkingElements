package AutomationTest.WorkingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxesAndButton {

	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}

	@Test
	public void WorkingTextAndButtonsElement() {

		WebElement Txt = driver.findElement(By.id("username"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ButtonElement = driver.findElement(By.className("radius"));

		Txt.clear();
		Txt.sendKeys("tomsmith");

		Password.clear();
		Password.sendKeys("SuperSecretPassword!");

		ButtonElement.click();
	}

	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}

}
