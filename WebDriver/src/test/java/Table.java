import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class Table {
	@Test
	public void rowsandcloumns() {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/table.xhtml;jsessionid=node010hcfctky59m7dgkc3zv8d5pn344880.node0");
		List<WebElement> size=driver.findElements(By.xpath("//*[@id=\"form:j_idt89_data\"]/tr"));
		int columns= size.size();
		System.out.println("tot no of columns  in the given table are "+columns);
		
		//tot no of rows
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"form:j_idt89_data\"]/tr[1]/td"));
		int totrows=rows.size();
		System.out.println("tottal no of rows in the given table are "+totrows);
		
		String s=driver.findElement(By.xpath("//*[@id=\"form:j_idt89_data\"]/tr[8]/td[3]/span[2]")).getText();
		System.out.println("the name of the representative is "+s);
		String s1=driver.findElement(By.xpath("//*[@id=\"form:j_idt89_data\"]/tr[8]/td[4]")).getText();
		System.out.println("date of joining of the representative is"+s1);
	
	}

}
