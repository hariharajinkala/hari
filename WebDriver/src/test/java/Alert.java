import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test; 

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
  @Test
  public void Alerts() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0r6ewo3j0nh22mvu1h1ftsrym342082.node0");
	  driver.findElement(By.id("j_idt88:j_idt91")).click();
	  Thread.sleep(2000);
	 driver.switchTo().alert().accept();
	  String ele=driver.findElement(By.id("simple_result")).getText();
	  System.out.println("the result of the simple alert is "+ele);
	    }
  @Test
  public void ConfirmDialog() throws InterruptedException  {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0r6ewo3j0nh22mvu1h1ftsrym342082.node0");
	  driver.findElement(By.id("j_idt88:j_idt93")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  String s=driver.findElement(By.id("result")).getText();
	  System.out.println("result of confirmDialouge is  "+s);
  }
  @Test
  public void SweetAlert() throws InterruptedException{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0r6ewo3j0nh22mvu1h1ftsrym342082.node0");
	  driver.findElement(By.id("j_idt88:j_idt95")).click();
	  Thread.sleep(2000);
	  String s1=driver.findElement(By.id("j_idt88:j_idt96_content")).getText();
	  System.out.println("sweet alert dialog is  "+s1);
	  driver.findElement(By.id("j_idt88:j_idt98")).click();
	  System.out.println("sweet alert is dissmissed");
  }  
  
  @Test
  public void promtdialog() throws InterruptedException{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0r6ewo3j0nh22mvu1h1ftsrym342082.node0");
	  driver.findElement(By.id("j_idt88:j_idt104")).click();
	  Thread.sleep(2000);
	  driver.switchTo().alert().sendKeys("HariHara");
	  driver.switchTo().alert().accept();
	  String s1=driver.findElement(By.id("confirm_result")).getText();
  System.out.println("promt dialog is  "+s1);
  
  }
	  
  
  
  
  
  
  
  
}
