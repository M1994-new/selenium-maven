package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class FindingElementsRegister {

	
	public static WebDriver driver;
	
	
	//Constructor
	public FindingElementsRegister(WebDriver ldriver) {
		FindingElementsRegister.driver=ldriver;
		
	}
	
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input") WebElement  firstName;
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input") WebElement lastName;
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea") WebElement address;
	@FindBy(xpath="//input[@type='email']") WebElement mailID;
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[4]/div/input") WebElement contactNo;
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[2]/input") WebElement gender;
	@FindBy(id="checkbox2") WebElement hobbies;
	@FindBy(tagName="multi-select") WebElement ul;
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[5]") WebElement language1;
	@FindBy(xpath="//*[@id=\"Skills\"]/option[6]") WebElement skill;
	@FindBy(xpath="//*[@id=\"countries\"]/option[44]") WebElement country;
	@FindBy(xpath="//*[@id=\"yearbox\"]/option[80]") WebElement year;
	@FindBy(xpath="//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select/option[2]") WebElement month;
	@FindBy(xpath="//*[@id=\"daybox\"]/option[26]") WebElement day;
	@FindBy(id="firstpassword") WebElement pwd;
	@FindBy(id="secondpassword") WebElement repwd;
	@FindBy(id="imagesrc") WebElement imageButton;
	@FindBy(name="signup") WebElement submit;
	
	
   public void elementFunctionsRegister(String fName, String lName,String location,String eID,String phone,String password, String Repassword) throws InterruptedException {
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		address.sendKeys(location);
		mailID.sendKeys(eID);
		contactNo.sendKeys(phone);
		gender.click();
		ul.click();
		language1.click();
		hobbies.click();
		skill.click();
		country.click();
		year.click();
		month.click();
		day.click();
		pwd.sendKeys(password);
		repwd.sendKeys(Repassword);
		imageButton.sendKeys("C:\\Users\\bosem\\OneDrive\\Desktop\\dab85d73-c3fb-4aec-ad46-3f491fa5e2d0.jpg");
		Thread.sleep(2000);
		submit.click();
		
					
	}
   
   public String firstNameText() {
	   
	   String attribute= firstName.getAttribute("value");
	   return attribute;
   }
	
	
}
