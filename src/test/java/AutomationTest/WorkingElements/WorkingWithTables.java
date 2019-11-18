package AutomationTest.WorkingElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTables {
	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");

	}

	@Test
	public void WorkingDropDown() {

		WebElement Table = driver.findElement(By.id("table1"));
		List<WebElement> Rows = Table.findElements(By.tagName("tr"));
		for (WebElement Row : Rows) {
			List<WebElement> Cols = Row.findElements(By.tagName("td"));
			for (WebElement Col : Cols) {
				System.out.println(Col.getText());
			}
			System.out.println();
		}

	}

	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}
}
