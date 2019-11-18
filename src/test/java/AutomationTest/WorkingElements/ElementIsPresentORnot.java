package AutomationTest.WorkingElements;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementIsPresentORnot {

	ChromeDriver driver;
	
	private boolean ISElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
	}
	
	
	@Test
	public void FindElement() {
		if(ISElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]")));
		{
			WebElement CheckBox = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			if(!CheckBox.isSelected())
				CheckBox.click();
			else
				Assert.fail("Element does not Exist");
		}
	}
	
	
	
	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}
}
