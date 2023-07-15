import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class HyperLink {

	@Test(priority = 0)
	public void mainTest() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.findElement(By.linkText("Go to Dashboard")).click();
		Thread.sleep(2000);
		//driver.navigate().back();
	}
	@Test
	public void destinationurl() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		String link=driver.findElement(By.linkText("Find the URL without clicking me.")).getAttribute("href");
		System.out.println("destinationn link is "+link);

	}
	@Test
	public void broken() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.findElement(By.linkText("Broken?")).click();
		String url=driver.getTitle();
		System.out.println(url);
		//		if(url=="Error 404 /lists.xhtml Not Found in ExternalContext as a Resource")
		//		{
		//			System.out.println("yes the link is broken");
		//		}
		//		else {
		//			System.out.println("link is not broken");
		//			}
		Assert.assertEquals(url, "Error 404 /lists.xhtml Not Found in ExternalContext as a Resource");
		{
			System.out.println("it is broken");
		}
	}
	@Test
	public void duplicatelink() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		String ele=driver.findElement(By.linkText("Go to Dashboard")).getAttribute("href");
		System.out.println(ele);

		driver.findElement(By.linkText("Go to Dashboard")).click();
		Thread.sleep(2000);
		String ele1=driver.getCurrentUrl();
		System.out.println(ele1);
		if(ele==ele1) {
			System.out.println("it entered into duplicate page");

		}
		else
		{
			System.out.println("different page");

		}	
		driver.navigate().back();
	}
	@Test
	public void totlinks() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");

		List<WebElement> links=driver.findElements(By.tagName("a"));
		int totlinks=links.size();
		System.out.println(totlinks);
	}
	@Test
	public void linksinlayout() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.findElement(By.linkText("How many links in this layout?")).click();
		Thread.sleep(2000);
		List<WebElement> links1=driver.findElements(By.xpath("//*[@id=\"j_idt88_content\"]/div/div"));
		int totlinks1=links1.size();
		System.out.println(totlinks1+"layout links in the layout");
	}

}