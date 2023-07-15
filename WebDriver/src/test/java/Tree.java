import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tree {
	@Test
	public void tree() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/tree.xhtml;jsessionid=node0hjt2hb9nlbnzaozr4p15dp30349854.node0");
		driver.findElement(By.xpath("//li[@id=\"j_idt88:0\"]/div/span[1]")).click();
		driver.findElement(By.xpath("//li[@id=\"j_idt88:0\"]/ul/li[1]/div/span[1]")).click();
		String s=driver.findElement(By.xpath("//*[@id=\"j_idt88:0_0\"]/ul")).getText();
		System.out.println(s);
	}
	@Test
	public void horizontaltree() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/tree.xhtml;jsessionid=node0hjt2hb9nlbnzaozr4p15dp30349854.node0");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"j_idt107\"]/table/tbody/tr/td[1]/div/span[1]")).click();
		String s1=driver.findElement(By.xpath("//*[@id=\"j_idt107\"]/table/tbody/tr/td[2]")).getText();
		System.out.println(s1);
	
	
	}
	
}
