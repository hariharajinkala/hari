import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Auth {
  @Test
  public void f() throws AWTException, InterruptedException {
	 
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://www.leafground.com/auth.xhtml");
		  driver.findElement(By.id("j_idt88:j_idt90")).click();
		  StringSelection user=new StringSelection("admin");
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(user, null);
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);	
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(2000);
			StringSelection password=new StringSelection("testleaf");
			  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(password, null);
						 r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);	
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				driver.get("http://leafground.com:8090/login");
				Thread.sleep(3000);
				String s=driver.findElement(By.xpath("/html/body")).getText();
				System.out.println(s);
				
			
		
		 
		
		
		
		 
	
		 
		 
  }
}
