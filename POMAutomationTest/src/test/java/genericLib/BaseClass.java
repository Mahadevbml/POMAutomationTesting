package genericLib;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public PropertyFile p=new PropertyFile();
	public WebdriverUtilitires drivervtilitires=new WebdriverUtilitires();
	
	@BeforeMethod
	public void openApp() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(p.getPropertyFile("url"));
		
		//In Selenium 4 version bellow implicitlyWait(10,TimeUnit.SECONDS) will not work
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time before throwing an exception. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//The setScriptTimeout command waits for the asynchronous parts of the web page to finish loading for a specified number of seconds
	    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	    
	    ////As the name suggests, pageLoadTimeout command waits for the page to load completely for a specified number of seconds.
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		
	}
	
	@AfterMethod
	public void closeApp(ITestResult result) throws IOException
	{
		int status=result.getStatus();
		String name=result.getName();
//		driver.quit();
		//status=1 it will give you the pass
		//status=2 it will give you the fail
		//status=3 it will give you the skip
		
		if(status==2)
		{
			Screenshot s=new Screenshot();
			s.getScreenshot(driver,name);
		}
		driver.quit();

		
	}
	
	public void fluentwaitMaetod()
	{
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30L))
		       .pollingEvery(Duration.ofSeconds(5L))
		       .ignoring(NoSuchElementException.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>()
             {
		     public WebElement apply(WebDriver driver)
		     {
		       return driver.findElement(By.id("foo"));
		     }
		   }
		   );
	}
	
	public void WebDriverWaitForElement()
	{
		//Applies only to specific elements as intended by the user and Must always specify “ExpectedConditions” on the element to be located 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("foo")));
	}

}
