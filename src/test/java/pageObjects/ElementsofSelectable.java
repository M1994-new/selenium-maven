package pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;




public class ElementsofSelectable {

	static WebDriver driver;
	
	
	public ElementsofSelectable(WebDriver ldriver) {
		
		ElementsofSelectable.driver=ldriver;
		
		
	}
	
	
	@FindBy(xpath="//a[@href='#Serialize']") WebElement serialize;
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[4]") WebElement option1;
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[5]") WebElement option2;
	@FindBy(xpath="//*[@id=\"Serialize\"]/ul/li[7]")WebElement option3;
	@FindBy(xpath="//*[@id=\"result\"]") WebElement result;
	
	public void selectableMethod() {
		
		serialize.click();
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL).click(option1).click(option2).click(option3).keyUp(Keys.LEFT_CONTROL)
        .build()
        .perform();
		
		
	}
	
	public String resultValid() {
		
		String text=result.getText();
		return text;
	}
	
	
	
}
