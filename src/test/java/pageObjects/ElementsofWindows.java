package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import casestudy1Tests.WindowsSwitch;
import reusableMethods.windowhandling;



public class ElementsofWindows {

	public static WebDriver driver;
	
	
	
	public ElementsofWindows(WebDriver ldriver) {
		
		ElementsofWindows.driver=ldriver;
		
	}
	
	public ElementsofWindows() {
		
	}
	
	@FindBy(xpath="//button[@class='btn btn-info']") WebElement simpleWindowButton;
	@FindBy(xpath="//a[@href='#Seperate']") WebElement seperateWindow;
	@FindBy(xpath="//button[@class='btn btn-primary']") WebElement seperateWindowButton;
	@FindBy(xpath="//a[@href='#Multiple']") WebElement multipleWindow;
	@FindBy(xpath="//*[@id=\"Multiple\"]/button") WebElement multipleWindowButton;
	
	String newURL;
	
	public String getNewURL() {
		return newURL;
	}


	
	public void switchWindowMethods() throws InterruptedException {
		
		
		simpleWindowButton.click();
		windowhandling.windowHandlingMethod(driver);
		Thread.sleep(2000);
		newURL= driver.getCurrentUrl();
		System.out.println(newURL);
		seperateWindow.click();
		seperateWindowButton.click();
		Thread.sleep(2000);
		windowhandling.windowHandlingMethod(driver);
		multipleWindow.click();
		multipleWindowButton.click();
		windowhandling.windowHandlingMethod(driver);
		
	}
	
	

	
}