import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerUsingJse {
	@Test
	public void f() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('datepicker1').value='22/07/2023'");
		js.executeScript("document.getElementById('datepicker2').value='22/07/2023'");
	
	
	
	
	}
}




















//
//String dp1=driver.findElement(By.id("datepicker1")).getText();
//System.out.println(dp1+" is the date you printed");