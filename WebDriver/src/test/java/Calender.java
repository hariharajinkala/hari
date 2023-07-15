import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {
	@Test
	public void meetingschedule() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/calendar.xhtml;jsessionid=node010hcfctky59m7dgkc3zv8d5pn344880.node0");
		driver.findElement(By.xpath("//*[@id=\"j_idt87:schedule\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[2]/td[6]/div/div[1]")).click();
		driver.switchTo().activeElement();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(
		driver.findElement(By.xpath("//*[@id='j_idt87:title']")))).sendKeys("SELENIUM");
		driver.findElement(By.id("j_idt87:j_idt98")).click();
		driver.findElement(By.id("j_idt87:addButton")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String s=driver.findElement(By.xpath("//*[@id=\"j_idt87:schedule\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[2]/td[6]/div/div[2]/div[1]/a/div[1]/div/div/div")).getText();
		System.out.println("evenet created for "+s);
		
		

	}

}
