import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	@Test
	public void normalmethod() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/charts.xhtml");
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\M ROKESH KUMAR\\Pictures\\New folder (2)\\akki.png");
		org.openqa.selenium.io.FileHandler.copy(src, destination);
		Thread.sleep(1000);
		File f=new File("C:\\Users\\M ROKESH KUMAR\\Pictures\\New folder (2)");
		File[] totfiles=f.listFiles();
		for(File df:totfiles)
			if(df.getName().equalsIgnoreCase("akki"))
			{
				System.out.println("your file is downloaded");

			}
	}
	@Test
	public void robotmethod() throws AWTException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/charts.xhtml");
		Robot r=new Robot();
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(dim);
		BufferedImage src=r.createScreenCapture(rect);
		File dest=new File("C:\\Users\\M ROKESH KUMAR\\Pictures\\New folder (2)\\selenium.png");
		
		ImageIO.write(src, "png", dest);
		File f=new File("C:\\Users\\M ROKESH KUMAR\\Pictures\\New folder (2)");
		File[] totfiles=f.listFiles();
		for(File df:totfiles)
			if(df.getName().equalsIgnoreCase("selenium.png"))
			{
				System.out.println("your file is downloaded");

			}
		
		
		
		
		
		
		
		
	}
}
