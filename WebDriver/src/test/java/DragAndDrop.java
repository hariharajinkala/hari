import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class DragAndDrop {
	@Test
	  public void draggable() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.leafground.com/drag.xhtml");
		  
		  WebElement ele=driver.findElement(By.id("form:conpnl_header"));
		  Actions act=new Actions(driver);
		  act.dragAndDropBy(ele, 250, 0).build().perform();
		  System.out.println("Draggable  action is successful");
	}
	@Test
	  public void droppable() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.leafground.com/drag.xhtml");
	
		  WebElement ele=driver.findElement(By.id("form:drop_header"));
		  WebElement ele2=driver.findElement(By.id("form:drag_content"));
		  Actions act=new Actions(driver);
		  act.dragAndDrop(ele2, ele).build().perform();
		  
  }
}
