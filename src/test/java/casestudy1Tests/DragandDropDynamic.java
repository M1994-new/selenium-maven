package casestudy1Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import reusableMethods.BaseClass;



public class DragandDropDynamic {

	WebDriver driver;
    BaseClass browMethod=new BaseClass();

	
	@BeforeClass
	public void browLaunch() {
				
		driver=browMethod.startApplication(driver, "http://demo.automationtesting.in/Dynamic.html");

	}
	
	@AfterClass
	public void tearDown() {
		
		browMethod.quitBrowser(driver);
		
	}
	
	
	@Test(priority=1)
	public void dragAndDropDynamic() throws InterruptedException {
		
		driver.get("http://demo.automationtesting.in/Dynamic.html");
		WebElement From=driver.findElement(By.id("mongo"));
		WebElement To=driver.findElement(By.id("droparea"));
		
		
		final String java_script = "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                "ction(format,data){this.items[format]=data;this.types.append(for" +
                "mat);},getData:function(format){return this.items[format];},clea" +
                "rData:function(format){}};var emit=function(event,target){var ev" +
                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                "'drop',tgt);emit('dragend',src);";



        ((JavascriptExecutor) driver).executeScript(java_script, From, To);
        Thread.sleep(2000);     
	}
	
}
