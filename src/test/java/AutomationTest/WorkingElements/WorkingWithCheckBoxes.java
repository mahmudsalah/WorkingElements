package AutomationTest.WorkingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithCheckBoxes {

	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

	}

	@Test
	public void WorkingCheckBoxes() {

		WebElement CheckBoxElement = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		if(!CheckBoxElement.isSelected())
		{
			CheckBoxElement.click();
		}else {
			CheckBoxElement.click();
		}

	}

	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}

}
