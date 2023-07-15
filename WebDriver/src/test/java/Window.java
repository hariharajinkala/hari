import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {
  @Test
  public void f() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	  String s1=driver.getTitle();
	  System.out.println(s1);
	  driver.findElement(By.id("j_idt88:new")).click();
	  Set<String> s=driver.getWindowHandles();
	  Iterator<String>itr=s.iterator();
	  String wd1=itr.next();
	  String wd2=itr.next();
	  driver.switchTo().window(wd2);
	  System.out.println(driver.getTitle()); 
  
  }
  @Test
  public void nooftabsopened() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	  System.out.println(driver.getTitle());
	  driver.findElement(By.id("j_idt88:j_idt91")).click();
	  Set<String>ws=driver.getWindowHandles();
	  int totno=ws.size();
	  System.out.println("tot no of windows are "+totno);
	 }
  @Test
  public void delaytabs() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	  driver.findElement(By.id("j_idt88:j_idt95")).click();
	  Thread.sleep(3000);
	  Set<String> tot=driver.getWindowHandles();
	 int tottabs= tot.size();
	 System.out.println("total no of tabs are "+tottabs);
	 driver.close();
  
  }
  @Test
  public void closetabsexpceptprimary() throws InterruptedException {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/window.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	    driver.findElement(By.id("j_idt88:j_idt93")).click();
	  Set<String> s=driver.getWindowHandles();
	  Iterator<String>itr=s.iterator();
	  String wd1=itr.next();
	  String wd2=itr.next();
	  String wd3=itr.next();
	  driver.switchTo().window(wd2);
	  driver.close();
	  driver.switchTo().window(wd3);
	  driver.close();	  
  
  }
}
