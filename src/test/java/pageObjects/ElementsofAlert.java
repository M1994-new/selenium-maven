package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import casestudy1Tests.SwitchToAlert;
import reusableMethods.SwitchingAlertsMethods;



public class ElementsofAlert {

	public static WebDriver driver;
	
	
	
	public ElementsofAlert(WebDriver ldriver) {
		
		ElementsofAlert.driver=ldriver;
		
	}
	
	@FindBy(xpath="//*[@id=\"OKTab\"]/button") WebElement alertwithOKButton;
	@FindBy(partialLinkText="OK & Cancel") WebElement alertwithOKCancelOptions;
	@FindBy(xpath="//button[@class='btn btn-primary']") WebElement alertwithOKCancelButton;
	@FindBy(xpath="//a[@href='#Textbox']") WebElement alertwithTextBoxOptions;
	@FindBy(xpath="//*[@id=\"Textbox\"]/button") WebElement alertwithTextBoxOptionButton;
	@FindBy(xpath="//*[@id=\"demo1\"]") WebElement result;
	
	

	

	public void alertSwitchMethods(WebDriver driver, String textinBox) throws InterruptedException {
		alertwithOKButton.click();
		SwitchingAlertsMethods.acceptAlert(driver);
		
		alertwithOKCancelOptions.click();
		alertwithOKCancelButton.click();
		SwitchingAlertsMethods.dismissAlert(driver);
		Thread.sleep(3000);
		
		alertwithTextBoxOptions.click();
		alertwithTextBoxOptionButton.click();
		Thread.sleep(3000);
		SwitchingAlertsMethods.insertTextinAlert(driver, textinBox);
		Thread.sleep(3000);
		
		
	}
	
	public String result() {
		
		return result.getText();
	}
	
}
