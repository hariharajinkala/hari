import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.core.util.FilePathUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class FileUploaddownload {
	@Test
	public void upload() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml");
		driver.findElement(By.id("j_idt88:j_idt89")).click();
		Thread.sleep(2000);
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
		String upld=driver.findElement(By.xpath("//span[@id=\"j_idt88:j_idt89\"]/span[2]")).getText();
		if(upld!=null) {
			System.out.println(" your file has uploded");
		}
		else {
			System.out.println("file not uploaded");
		}
	}

	@Test(priority =1)
	public void download() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml");
		driver.findElement(By.id("j_idt93:j_idt95")).click();
		Thread.sleep(5000);
		File f=new File("C:\\Users\\M ROKESH KUMAR\\Downloads");
		File[] totfiles=f.listFiles();
		for(File sf:totfiles)
			if(sf.getName().equalsIgnoreCase("TestLeaf Logo.PNG"))
			{
				System.out.println("your file is downloaded");

			}


	}
}
