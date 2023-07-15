import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Message {
	@Test
	public void message() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/messages.xhtml");
		driver.findElement(By.id("j_idt100:submitButton")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String err=driver.findElement(By.id("j_idt100:j_idt104_error-detail")).getText();
		System.out.println("first name error msg is  "+err);
		String err2=driver.findElement(By.id("j_idt100:j_idt108_error-detail")).getText();
		System.out.println("last name error msg "+err2);
		String err3=driver.findElement(By.id("j_idt100:j_idt112_error-detail")).getText();
		System.out.println("email error  msg is "+err3);


	}
}
