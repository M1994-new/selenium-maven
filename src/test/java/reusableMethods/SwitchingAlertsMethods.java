package reusableMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class SwitchingAlertsMethods {

	WebDriver driver;
	
	
	public static void acceptAlert(WebDriver driver) {
		
		driver.switchTo( ).alert( ).accept();
	}
	
	public static void dismissAlert(WebDriver driver) {
		
		driver.switchTo( ).alert( ).dismiss();
		
	}
	
	public static void insertTextinAlert(WebDriver driver, String textInAlert) {
		
		Alert promptAlert  = driver.switchTo().alert();		    
		promptAlert.sendKeys(textInAlert);
	    promptAlert.accept();
		
	}
	
	
}
