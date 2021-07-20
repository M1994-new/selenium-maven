package reusableMethods;

import org.openqa.selenium.WebDriver;

public class windowhandling {

	
	WebDriver driver;
	static String originalWindow;
	
	
	
	public static void windowHandlingMethod(WebDriver driver) throws InterruptedException {
		
		originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);
		        Thread.sleep(3000);
		           
		        driver.close();
		    }
		    
		    
		}
		driver.switchTo().window(originalWindow);
		
		
	}
}
