import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Wait {
	@Test
	  public void wait1() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.leafground.com/waits.xhtml");
		  driver.findElement(By.id("j_idt87:j_idt89"));		 
		  WebElement ele= driver.findElement(By.id("j_idt87:j_idt90"));
		  WebDriverWait wait=new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(ele));
		  System.out.println(ele);
		  
  }
}
