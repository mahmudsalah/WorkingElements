package AutomationTest.WorkingElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithDragAndDrop {
	
	ChromeDriver driver;

	@BeforeTest
	public void OpenBrowser() {

		String ChromePath = System.getProperty("user.dir") + "\\Resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");

	}

	@Test
	public void DragAndDropTest() {

		WebElement Source = driver.findElement(By.id("draggable"));
		WebElement Target = driver.findElement(By.id("droppable"));
		
		Actions Builder = new Actions(driver);
		Builder.dragAndDrop(Source, Target).perform();;
		Assert.assertEquals("Dropped!", Target.getText());
		//System.out.println(Target.getText());
		
	}

	@AfterTest
	public void CloseBrowser() {
		//driver.quit();
	}

}
