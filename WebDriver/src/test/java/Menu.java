import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Menu {

	@Test
	public void customers() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.findElement(By.linkText("Customers")).click();
		String s=driver.findElement(By.xpath("//ul[@class=\"ui-widget-content ui-menu-list ui-corner-all ui-helper-clearfix ui-menu-child ui-shadow\"][1]")).getText();
		System.out.println(s);
	}
	@Test
	public void  tabmenu() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt116\"]/div[2]/h3/span")).click();
		String s1=driver.findElement(By.xpath("//div[@id=\"j_idt87:j_idt116_j_idt123\"]/ul/li")).getText();
		System.out.println(s1);
	}
	@Test
	public void slidemenu() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.findElement(By.xpath("//div[@id=\"j_idt87:j_idt134\"]/div/div[1]/ul/li[1]/a/span[2]")).click();
		Thread.sleep(2000);
		String s2=driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt134\"]/div/div[1]/ul/li[1]/ul")).getText();
		System.out.println(s2);
	}

	@Test
	public void options() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/menu.xhtml");
		driver.findElement(By.id("j_idt87:j_idt144_button")).click();
		String s3=driver.findElement(By.xpath("//div[@id=\"j_idt87:j_idt144_menu\"]/ul")).getText();
		System.out.println(s3);
	}
}
