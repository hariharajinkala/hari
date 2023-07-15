import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingInAdobe {
  @Test
  public void f() throws InterruptedException, AWTException {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.adobe.com/in/acrobat/online/word-to-pdf.html");
		driver.findElement(By.xpath("//div[@data-test-id=\"file-upload-choose-button-container\"]")).click();
		Thread.sleep(5000);
		Robot r=new Robot();
		String FilePath="C:\\Users\\M ROKESH KUMAR\\Downloads\\Resume.docx";
		StringSelection filepath=new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);	  
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
WebDriverWait wait=new WebDriverWait(driver, 40);

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"dialog-close\"]"))).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"spectrum-Button_e2d99e Download__downloadButton___2qFEa\"]"))).click();

  
 File f=new File("C:\\Users\\M ROKESH KUMAR\\Downloads");
	File[] totfiles=f.listFiles();
	for(File df:totfiles)
		if(df.getName().equalsIgnoreCase("Resume.pdf"))
		{
			System.out.println("your file is downloaded");

		}
  
  
  }
}
