package AutomationTest.WorkingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDropDownList {
	
	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

	}

	@Test
	public void WorkingDropDown() {

		WebElement DropDownList = driver.findElement(By.id("dropdown"));
		Select selectelement = new Select(DropDownList);
		selectelement.selectByVisibleText("Option 2");
	}

	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}

}
