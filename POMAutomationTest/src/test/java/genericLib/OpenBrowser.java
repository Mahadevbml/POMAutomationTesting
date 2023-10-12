package genericLib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser 
{

	public static void main(String[] args)
	{
		
		//Chrome 116X
		//System.setProperty("webdriver.chrome.driver", "user.exe.file");
		
//		ChromeOptions co=new ChromeOptions();
//		co.setBrowserVersion("117");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gamil.com/");
		
		//Implicit Wait directs the Selenium WebDriver to wait for a certain measure of time before throwing an exception. 
		//Once this time is set, WebDriver will wait for the element before the exception occur
		//Applies to all elements in a test script and No need to specify “ExpectedConditions” on the element to be located
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//The setScriptTimeout command waits for the asynchronous parts of the web page to finish loading for a specified number of seconds
	    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	    
	    ////As the name suggests, pageLoadTimeout command waits for the page to load completely for a specified number of seconds.
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.close();

	}

}
