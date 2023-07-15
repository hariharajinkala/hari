package functionality;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import elements.ObjectRepository;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
@Listeners(listeners.AmznListeners.class)
public class Amazon {
	
	@Test

	public void amzn() throws InterruptedException, IOException {
			WebDriver driver = null;		
			ExtentReports exr=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\M ROKESH KUMAR\\Desktop\\hari\\report.html");
			exr.attachReporter(spark);
			exr.flush();
			
		FileInputStream fs=new FileInputStream("src//test//java//config.properties");
		Properties prop=new Properties();
		prop.load(fs);
		String browsername=prop.getProperty("browser");
		String urllink=prop.getProperty("url");
		String excelpath=prop.getProperty("path");	
		
		
		if(browsername.equalsIgnoreCase("chrome")) {

			ChromeOptions ch=new ChromeOptions();
			ch.addArguments("Incognito");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(ch);
			System.out.println("Executing your code in chrome browser,icognito window");
			
		}
		else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}	
		
		Thread.sleep(3000);
		FileInputStream fs1=new FileInputStream(excelpath);
		XSSFWorkbook wb=new XSSFWorkbook(fs1);
		XSSFSheet ws=wb.getSheetAt(0);
		for(int i=1;i<=ws.getLastRowNum();i++)
		{
			
			driver.get(urllink);
			XSSFRow r1=ws.getRow(i);
			String name1=r1.getCell(0).getStringCellValue();
			double mobno=r1.getCell(1).getNumericCellValue();
			String mail=r1.getCell(2).getStringCellValue();
			String pswd=r1.getCell(3).getStringCellValue();

			PageFactory.initElements(driver, ObjectRepository.class);

			ObjectRepository.name.sendKeys(name1);
			ObjectRepository.phone.sendKeys(String.valueOf(mobno));
			ObjectRepository.email.sendKeys(mail);
			ObjectRepository.pswd.sendKeys(pswd);
			ObjectRepository.cntbtn.click();
		}
		System.out.println("POM, DATADRIVEn are implemented successfully");

		File f1=new File("C:\\Users\\M ROKESH KUMAR\\Desktop\\hari\\coockies.data");
		try {
			f1.createNewFile();
			FileWriter fw=new FileWriter(f1);
			BufferedWriter bw=new BufferedWriter(fw);
			for( Cookie ck :driver.manage().getCookies()) {
				System.out.println(ck.getName()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.getValue()+";"+ck.isSecure());
			
				bw.newLine();
				bw.close();
			fw.close();
			
			}
		}
			catch (Exception e) {
				System.out.println(e);
				
			}
		System.out.println("cookies data stored successfully");
		}
	
	@Test(dependsOnMethods = "amzn")
	public void gettitle() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/ap/register?openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		String s=driver.getTitle();
		Assert.assertEquals(driver.getTitle(), s);
		
	}
	}


			
		


