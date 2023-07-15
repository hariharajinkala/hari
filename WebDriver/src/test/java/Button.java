import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {
	@Test
	public void gettitle	() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		String title=driver.getTitle();
		System.out.println(title);
	}
	@Test
	public void diasbled() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");	  
		Boolean dis=driver.findElement(By.id("j_idt88:j_idt92")).isEnabled();
		if(dis==false) {
			System.out.println("yes it is disabled to click");
		}
		else
		{
			System.out.println("it enabled to click");
		}
	}
	@Test
	public void buttonposition() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		Point pos= driver.findElement(By.id("j_idt88:j_idt94")).getLocation();
		int x_pos=  pos.getX();
		int y_pos=pos.getY();
		System.out.println("x position is "+x_pos);
		System.out.println("y position is "+y_pos);
	}
	@Test
	public void buttoncolor() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		String clr=driver.findElement(By.id("j_idt88:j_idt96")).getCssValue("color");
			System.out.println(clr);
	
		String clr2=Color.fromString(clr).asHex();
		System.out.println(clr2);
	
	}
	@Test
	public void btndimensiond() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		Dimension dim=driver.findElement(By.id("j_idt88:j_idt98")).getSize();
		System.out.println(dim);	 
	}
	@Test
	public void clrchange() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		String clr1=driver.findElement(By.id("j_idt88:j_idt100")).getAttribute("style");
		System.out.println("before mouseover color"+clr1);
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.id("j_idt88:j_idt100"));
		act.moveToElement(ele);
		String clr2=driver.findElement(By.id("j_idt88:j_idt100")).getAttribute("style");
		System.out.println(clr2);
	}
	@Test
	public void hiddenbtn() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		boolean btndis=driver.findElement(By.id("j_idt88:j_idt102:imagePanel")).isDisplayed();
		if (btndis==true)
		{
			System.out.println("it is diabled to click on any hidden button");
		}
		else
		{
			System.out.println("it is enabled for cliking");
		}
	}
	@Test
	public void roundedbtns() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/button.xhtml");
		List<WebElement> totbtn= driver.findElements(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[4]/button"));
		int totcnt=totbtn.size();
		System.out.println(totcnt+" are the total no of buttons");	 
		
	}
}