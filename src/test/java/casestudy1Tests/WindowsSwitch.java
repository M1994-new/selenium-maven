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
import pageObjects.ElementsofWindows;
import reusableMethods.BaseClass;



public class WindowsSwitch extends BaseClass {
   
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	static Logger logger=LogManager.getLogger(WindowsSwitch.class.getName());
	
	
	@BeforeClass
	public void browLaunch() {
		
		report=BaseClass.getReport();
       	test = report.startTest("WindowsSwitch");
		driver= super.startApplication(driver, "http://demo.automationtesting.in/Windows.html");
		test.log(LogStatus.INFO,"WindowsSwitch URL launched");
		logger.info("Application launched");
	}
	
	@AfterClass
	public void tearDown() {
		
		report.endTest(test);
		report.flush();
		super.quitBrowser(driver);
		logger.info("Application closed");
	}
	
	@Test(priority=0)
	public void simpleWindowswitch() throws InterruptedException {
		
		
		ElementsofWindows elementsofWindows=PageFactory.initElements(driver, ElementsofWindows.class);
		elementsofWindows.switchWindowMethods();
		
		
		
		logger.info("Windows are swicthed successfully");
		
		String childURL=elementsofWindows.getNewURL();
		
		if(childURL.contains("http://demo.automationtesting.in/Windows.html")) {
			
			test.log(LogStatus.PASS,"Windows are switched and get back to parent window");
		}
		
		else {
			
			test.log(LogStatus.FAIL,"Windows are not switched");
		}
		
		
		Thread.sleep(2000);
	}
	

	
}
