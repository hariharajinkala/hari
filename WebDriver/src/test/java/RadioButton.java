import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {
	@Test
	public void favouritebrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml");
		String brwsr=driver.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[1]/label")).getText();
		driver.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[1]/label")).click();
		System.out.println("1.my fav browser is "+ brwsr);
	}
	@Test
	public void unselect() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml"); 
		driver.findElement(By.xpath("//*[@id=\"j_idt87:city2\"]/div/div[2]/label")).click();
		Thread.sleep(2000);
		System.out.println("Bengaluru is selcted");
		driver.findElement(By.xpath("//*[@id=\"j_idt87:city2\"]/div/div[2]/label")).click();
		System.out.println("Bengaluru is unselcted");	  
	}


	@Test
	public void defaultselect(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml"); 
	
		Boolean sel3=driver.findElement(By.xpath("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[3]/div")).isSelected();
		if(sel3==false) {
			System.out.println("3rd option is seleceted");
		}
		else System.out.println("not selected");

	}
	@Test
	public void ageselect(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/radio.xhtml"); 
		boolean select=driver.findElement(By.xpath("//*[@id=\"j_idt87:age\"]/div/div[2]/div")).isSelected();
		
	if(select==false) {
		System.out.println("your age is selected");
	}
	else {
		System.out.println("not selected");
	}
	}
}
