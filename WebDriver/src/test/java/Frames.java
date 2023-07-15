import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
  @Test
  public void clickme() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	  driver.switchTo().frame(0);
	  driver.findElement(By.id("Click")).click();
	 String s=driver.findElement(By.id("Click")).getText();
	 System.out.println("the result of click me is "+s);  
  }
  @Test
  public void insidenestedframe() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	  WebElement frm1=driver.findElement(By.xpath("//*[@id=\"j_idt88\"]/div/div[2]/div/iframe"));
	  driver.switchTo().frame(frm1);
	 driver.switchTo().frame("frame2");
	  driver.findElement(By.id("Click")).click();
	 String s= driver.findElement(By.id("Click")).getText();
	  System.out.println("after clicking inside trhe nested frame the result is  "+s);
	  }
  @Test
  public void totnoframes() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node01id3a1jy5j9391k9xkudqcm0us342470.node0");
	 
	 List<WebElement> wb= driver.findElements(By.tagName("iframe"));
	 int totfrms=wb.size();
	 System.out.println("total no of frames in pages is "+totfrms);
  }
}
