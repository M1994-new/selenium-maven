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
import pageObjects.ElementsofSelectable;
import reusableMethods.BaseClass;

public class Selectable extends BaseClass {

  WebDriver driver;
  static ExtentTest test;
  static ExtentReports report;
  static Logger logger=LogManager.getLogger(Selectable.class.getName());
	
	
	@BeforeClass
    public void browLaunch() {
		
		report=BaseClass.getReport();
       	test = report.startTest("Selectable");
		
		driver=super.startApplication(driver, "http://demo.automationtesting.in/Selectable.html");
		
		test.log(LogStatus.INFO,"Selectable URL launched");
		logger.info("Application launched");
	}
	
	@AfterClass
    public void tearDown() {
   		
		report.endTest(test);
		report.flush();
		super.quitBrowser(driver);
		logger.info("Application is closed");
	}
	
	@Test
	public void SelectableMethod() throws InterruptedException {
		
		ElementsofSelectable elementsofSelectable=PageFactory.initElements(driver, ElementsofSelectable.class);
		elementsofSelectable.selectableMethod();
		
		
		
		logger.info("Options are selected");
		
		String validationSelectable= elementsofSelectable.resultValid();
		
		if(validationSelectable.contains("Cross Browser Testing , Extent Reports , Functional Testing")) {
			
			test.log(LogStatus.PASS,"Test Passed and elements selected properly");
			
		}
		
		else {
			test.log(LogStatus.FAIL,"Test Failed");
			
		}
		
		
    
 		 Thread.sleep(3000);      
		
		
		
	}
            
	
        
	}

