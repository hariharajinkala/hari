
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {
	@Test
	public void datepicker() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement ele=driver.findElement(By.xpath("//div[@id=\"mCSB_3_container\"]/p[2]/input"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
		ele.clear();
		ele.sendKeys("Selenium");
		Thread.sleep(2000);
		WebElement ele2=driver.findElement(By.xpath("//*[@id=\"mCSB_3_container\"]/p[6]/input"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele2);
		
		ele2.sendKeys("HCL");
		WebElement ele3=driver.findElement(By.xpath("//*[@id=\"mCSB_3_container\"]/p[9]/textarea"));
		js.executeScript("arguments[0].scrollIntoView(true)", ele3);
		ele.click();
		ele.sendKeys("bangalore");

	}
}
