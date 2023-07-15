import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	@Test
	public void uiUtomationtool() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		WebElement ele=driver.findElement(By.xpath("//*[@class=\"ui-selectonemenu\"]"));
		Select sel=new Select(ele);
		sel.selectByVisibleText("Selenium");

	}
	@Test
	public void prfdcntry() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		//driver.findElement(By.xpath("//*[@id=\"j_idt87:country_input\"]")).click();
		WebElement ele1=driver.findElement(By.id("j_idt87:country_input"));
		Select sel=new Select(ele1);
		sel.selectByVisibleText("India");
	}
	@Test
	public void choosethecourse() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		WebElement ele=driver.findElement(By.xpath("//button[@aria-label=\"Show Options\"]"));
		Select sel=new Select(ele);
		Thread.sleep(2000);
		System.out.println(sel);
		sel.selectByVisibleText("Selenium WebDriver");


	}
	@Test
	public void languageselection() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.findElement(By.xpath("//div[@id=\"j_idt87:lang\"]")).click();
	
		Select dd=new Select(driver.findElement(By.id("j_idt87:lang_input")));
		Thread.sleep(3000);
		dd.selectByVisibleText("English");

	}
}
