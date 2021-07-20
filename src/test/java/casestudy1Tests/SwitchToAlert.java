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
import pageObjects.ElementsofAlert;
import reusableMethods.BaseClass;




public class SwitchToAlert extends BaseClass {

    WebDriver driver;
    static ExtentTest test;
	static ExtentReports report;
	
	static Logger logger=LogManager.getLogger(SwitchToAlert.class.getName());
	
	
    @BeforeClass
	public void browLaunch() {
		
    	report=BaseClass.getReport();
       	test = report.startTest("SwitchToAlert");
    	driver=super.startApplication(driver, "http://demo.automationtesting.in/Alerts.html");
    	test.log(LogStatus.INFO,"Alert URL launched");
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
	public void allAlertsSwitch() throws Exception {
		
		ElementsofAlert elementsofAlert=PageFactory.initElements(driver, ElementsofAlert.class);
		
		elementsofAlert.alertSwitchMethods(driver, "Test User");
		
		
		
		logger.info("Switching to Alerts successfully");
		
		Thread.sleep(3000);
		String validation=elementsofAlert.result();
		
		
		
		if(validation.contains("Test User")) {
			
			test.log(LogStatus.PASS, "Text box is filled");
		}
		
		else {
			
			test.log(LogStatus.FAIL, "Text box is not filled");
		}
			
		
	
		
	}
}
		
		
		
	
	


