package reusableMethods;

import java.util.concurrent.TimeUnit;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
 WebDriver driver;
static ExtentTest test;
static ExtentReports extent;
public static Logger logger=null;


@BeforeTest
   public static void logsReport() {
	   
	   String log4jPath=System.getProperty("user.dir")+ "/log4j.properties";
	   PropertyConfigurator.configure(log4jPath);
   }


    public static ExtentReports getReport() {
	
    	extent = new ExtentReports("C:\\Users\\bosem\\eclipse-workspace\\casestudy1\\extentreport.html",false);
	
	return extent;
	
}
    
    
	
	public WebDriver startApplication(WebDriver driver,String appUrl) {		
		
		System.setProperty("webdriver.chrome.driver", "//C://Users//bosem//Downloads//chromedriver_win32//chromedriver.exe");
		driver=new ChromeDriver();
				
		
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
		
		
	}
	
	public void quitBrowser(WebDriver driver) {
			
		
		driver.quit();
	}

	
}


