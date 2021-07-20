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
import pageObjects.DatePickerElements;
import reusableMethods.BaseClass;





public class DatePicker extends BaseClass {

	 WebDriver driver;
	 static ExtentTest test;
	 static ExtentReports report;
	 static Logger logger=LogManager.getLogger(DatePicker.class.getName());
	 
	 
	@BeforeClass
public void browLaunch() {
		
		report=BaseClass.getReport();
       	test = report.startTest("DatePicker");
		driver=super.startApplication(driver, "http://demo.automationtesting.in/Datepicker.html");
		
		test.log(LogStatus.INFO,"DatePicker URL launched");
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
	public void DatePickerMethod() {
		
		DatePickerElements datePickerElements=PageFactory.initElements(driver, DatePickerElements.class );
		datePickerElements.selectDates();
		datePickerElements.dateResult();
		
		
		logger.info("DatePicker is selected and date is inserted");
		
		test.log(LogStatus.PASS,"Date is selected");
	
	}
	
}
