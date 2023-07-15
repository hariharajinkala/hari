import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Lists {
	@Test
	public void f() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/list.xhtml;jsessionid=node0jiowxn4sab0516pat78cs0hr2349505.node0");
		List<WebElement> items=driver.findElements(By.xpath("//*[@id=\"j_idt88_content\"]/div/div"));
		int totitems=items.size();
		System.out.println(("the tottal no of items are ")+totitems);
		String itemnames=driver.findElement(By.xpath("//*[@id=\"j_idt88_content\"]/div/div")).getText();
		System.out.println("these are the items which was on the web page "+itemnames);
	}
	@Test
	public void picklist() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/list.xhtml;jsessionid=node0jiowxn4sab0516pat78cs0hr2349505.node0");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement wb= driver.findElement(By.id("pickList"));
		js.executeScript("arguments[0].scrollIntoView(true)", wb);
		driver.findElement(By.xpath("//ul[@class=\"ui-widget-content ui-picklist-list ui-picklist-source ui-corner-bottom ui-sortable\"]")).click();
		String s=driver.findElement(By.xpath("//ul[@class=\"ui-widget-content ui-picklist-list ui-picklist-source ui-corner-bottom ui-sortable\"]")).getText();
		System.out.println("these are the country names moved from to destination "+s);
		driver.findElement(By.xpath("//*[@id=\"pickList\"]/div[3]/div/button[2]")).click();

	}
	@Test
	public void orderlist() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/list.xhtml;jsessionid=node0jiowxn4sab0516pat78cs0hr2349505.node0");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement wb= driver.findElement(By.id("pickList"));
		js.executeScript("arguments[0].scrollIntoView(true)", wb);
		Actions act=new Actions(driver);
		WebElement source=  driver.findElement(By.xpath("//ul[@class=\"ui-widget-content ui-orderlist-list ui-corner-bottom ui-sortable\"]/li[2]"));
		WebElement dest= driver.findElement(By.xpath("//ul[@class=\"ui-widget-content ui-orderlist-list ui-corner-bottom ui-sortable\"]/li[5]"));
		Thread.sleep(2000);
		act.dragAndDrop(source, dest).build().perform();


	}
}