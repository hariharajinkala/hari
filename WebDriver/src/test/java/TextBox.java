import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class TextBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");

		driver.findElement(By.id("j_idt88:name")).sendKeys("HariPrasad");
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("tirupathi");
		Boolean clickable=driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		System.out.println("clickable is "+clickable);
		if(clickable==false) {
			System.out.println("it is disabled");
		}
		else {
			System.out.println("it is enabled");
		}
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		System.out.println("cleared");
		String data=driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value");
		System.out.println(data);
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("HariHara@hcl.com");
		WebElement element1=(WebElement) driver.findElement((By.id("j_idt88:j_idt99")));
		element1.sendKeys(Keys.TAB);		



		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("hi i'm hari");
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt103_editor\"]/div[1]/p")).sendKeys("my office location is banalore");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt103_toolbar\"]/span[5]/button[2]")).click();


		WebElement ele=driver.findElement(By.id("j_idt106:thisform:age"));

		ele.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String txt=driver.findElement(By.xpath("//span[@class=\"ui-message-error-detail\"]")).getText()	;
		System.out.println(txt+"  is the confirmed error message");

		Dimension before_click=driver.findElement(By.id("j_idt106:float-input")).getSize();
		System.out.println("before click label position is  "+before_click);
		driver.findElement(By.id("j_idt106:float-input")).click();Thread.sleep(2000);
		Dimension after_click=driver.findElement(By.id("j_idt106:float-input")).getSize();
		System.out.println("after click label position is "+after_click);
		if(before_click!=after_click) {
			System.out.println("label position changes");
		}
		else {
			System.out.println("label position not changed");
		}


		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("hari");
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//li[@data-item-label=\"hari2\"]")).click();









	}


}





