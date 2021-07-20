package casestudy1Tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageObjects.ElementsofFrames;
import reusableMethods.BaseClass;

import org.testng.annotations.AfterClass;

public class SwitchFrames extends BaseClass {

	 WebDriver driver;
	 static ExtentTest test;
	 static ExtentReports report;
	 static Logger logger=LogManager.getLogger(SwitchFrames.class.getName());
	 

	@BeforeClass
	public void browLaunch() {
		
		
		report=BaseClass.getReport();
		test = report.startTest("SwitchFrames");

		driver=super.startApplication(driver, "http://demo.automationtesting.in/Frames.html");
		test.log(LogStatus.INFO,"Frame URL launched");
		logger.info("Application started");

	}

	@AfterClass
	public void tearDown() {
		
		report.endTest(test);
		report.flush();
		super.quitBrowser(driver);
		logger.info("Application is closed");
	}
	
	@Test
    public void Frame() throws InterruptedException {
		
		ElementsofFrames elementFrame = PageFactory.initElements(driver, ElementsofFrames.class);
		elementFrame.FrameMethods("Testing QA", "Hello");
		
		
		
		logger.info("Frames are switched and selected");
		String validationFrame2=elementFrame.textResultFrame2();
		
		if(validationFrame2.contains("Hello")){
			
			test.log(LogStatus.PASS,"Nested Frame is selected and filled");
		}
		else {
			test.log(LogStatus.FAIL,"Test Failed");
		}
		
				
		Thread.sleep(3000);
	

 }

	
}

