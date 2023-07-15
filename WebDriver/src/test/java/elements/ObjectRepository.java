package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectRepository {
	
	@FindBy(id="ap_customer_name")
	public static WebElement name;
	@FindBy(id="ap_phone_number")
public static WebElement phone;
	@FindBy(id="ap_email")
public static WebElement email;
	@FindBy(id="ap_password")
public static WebElement pswd;
	@FindBy(id="continue")
public static WebElement cntbtn;
	






}




	