import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {
	@Test
	public void basiccheclbox() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		driver.findElement(By.id("j_idt87:j_idt89")).click();
		String sel=driver.findElement(By.id("j_idt87:j_idt89_input")).getAttribute("aria-checked");
		System.out.println("is the check box ic clicked -"+sel);
	}
	@Test
	public void notification2() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt91\"]/div[2]")).click();
		Thread.sleep(3000);
		String txt=driver.findElement(By.xpath("//*[@id=\"j_idt87:msg_container\"]/div/div/div[2]/span")).getText();
		System.out.println("is the ajax notification is checked or not - " +txt);
	}
	@Test
	public void favlang() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		driver.findElement(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td[1]/label")).click();
		String lng=driver.findElement(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td[1]/label")).getText();
		System.out.println("my favourite language is - "+lng );
	}
	@Test
	public void notification() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		driver.findElement(By.id("j_idt87:ajaxTriState")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String status1=driver.findElement(By.xpath("//*[@id=\"j_idt87:id_container\"]/div/div/div[2]/span")).getText();

		System.out.println("for  the 1st time --"+status1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("j_idt87:ajaxTriState")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String status2=driver.findElement(By.xpath("//*[@id=\"j_idt87:id_container\"]/div/div/div[2]/span")).getText();
		System.out.println(" for  the 2nd time --"+status2);
		String s3=driver.findElement(By.xpath("//*[@id=\"j_idt87:id_container\"]/div/div/div[2]/span")).getText();
		driver.findElement(By.id("j_idt87:ajaxTriState")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(s3);
	}
	@Test
	public void toggleswitch() throws InterruptedException  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		driver.findElement(By.xpath("//div[@class=\"ui-toggleswitch-slider\"]")).click();
		Thread.sleep(2000);
		String txt3=driver.findElement(By.xpath("//*[@id=\"j_idt87:msg_container\"]/div/div/div[2]/span")).getText();
		System.out.println("toogle switch hasbeen "+txt3);
	}
	@Test
	public void checkboxdisabled() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		Boolean btndsbld=driver.findElement(By.id("j_idt87:j_idt102")).isEnabled();
		if(btndsbld==true) {
			System.out.println("it is disabled");
		}
		else
			System.out.println("it is enabled");
	}
	@Test
	public void multioption() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01puesa61yw8rk118uth5zo5aas339662.node0");
		driver.findElement(By.id("j_idt87:multiple")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li[1]/label")).click();
		String citi1=driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li[1]/label")).getText();;
		System.out.println(citi1+" is the 1st citi selected");//	System.out.println("1st selection is "+totcities.getText());
		driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li[5]/label")).click();
		String citi2=driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li[5]/label")).getText();
		System.out.println(citi2+" is the selecond citi selected");

	}

}