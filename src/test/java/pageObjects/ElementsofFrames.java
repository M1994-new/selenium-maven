package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ElementsofFrames {

	public static WebDriver driver;
	
	
	public ElementsofFrames(WebDriver ldriver) {
		ElementsofFrames.driver=ldriver;
		
	}
	
	
	@FindBy(xpath="/html/body/section/div/div/div/input") WebElement textFrame;
	@FindBy(xpath="//a[@href='#Multiple']") WebElement multiFrameOptions;
	@FindBy(xpath="//*[@id=\"Multiple\"]/iframe") WebElement parentFrame;
	@FindBy(xpath="/html/body/section/div/div/iframe") WebElement childFrame;
	@FindBy(xpath="/html/body/section/div/div/div/input") WebElement textFrame1;
	
	
	public void FrameMethods(String frameText, String nestedFrameText) throws InterruptedException {
		
		driver.switchTo().frame(0);
		
		textFrame.sendKeys(frameText);
		
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		
		multiFrameOptions.click();
		
		driver.switchTo().frame(parentFrame);
		driver.switchTo().frame(childFrame);
		
		textFrame1.sendKeys(nestedFrameText);
		
		
	}
	
   
	
	public String textResultFrame2() {
		
		String attribute= textFrame1.getAttribute("value");
		return attribute;
		
	}
	
	
}