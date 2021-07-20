package pageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class DatePickerElements {

	static WebDriver driver;
	
	
	public DatePickerElements(WebDriver ldriver) {
		
		DatePickerElements.driver=ldriver;
		
	}
	
	
	@FindBy(id="datepicker2") WebElement date;
	
	public void selectDates() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.getElementById('datepicker1').value='07/31/2021'");
        date.sendKeys("07/31/2021");
        date.sendKeys(Keys.ENTER);
        
	}
	
	public void dateResult() {
		System.out.println(date.getText());
	}
	
}
