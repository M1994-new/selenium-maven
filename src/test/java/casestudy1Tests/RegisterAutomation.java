package casestudy1Tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.FindingElementsRegister;
import reusableMethods.BaseClass;

  public class RegisterAutomation extends BaseClass{

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Logger logger=LogManager.getLogger(RegisterAutomation.class.getName());

	
	 @BeforeClass
	 public void browLaunch() {	
		
		 report=BaseClass.getReport();
	     test = report.startTest("RegisterAutomation");
		
		driver=super.startApplication(driver, "http://demo.automationtesting.in/Register.html");
		
		test.log(LogStatus.INFO, "The browser launched and Register URL opened");
		logger.info("Application started");
		
	}
	
	 @AfterClass
	
	 public void tearDown() {
		
		 report.endTest(test);
		 report.flush();
		 super.quitBrowser(driver);
		logger.info("Application closed");
	}
	
	  @Test
	  public void registerUser() throws Exception {
			
			
			FindingElementsRegister FindElementsWebpage=PageFactory.initElements(driver, FindingElementsRegister.class);
			FindElementsWebpage.elementFunctionsRegister("Test", "Automation", "Hinjewadi, Pune", "automation@gmail.com", "5285258632", "Selenium@2021", "Selenium@2021");
			
			
			
			logger.info("Form is filled");
			
			String validationPoint1= FindElementsWebpage.firstNameText();
					
			if(validationPoint1.contains("Test")) {
				
				  test.log(LogStatus.PASS, "FirstName is filled");
					  }
				
			else {
							
				test.log(LogStatus.FAIL, "FirstName is empty");
			}
					
			Thread.sleep(3000);			
		

			
	  }
  }
	
	
	

