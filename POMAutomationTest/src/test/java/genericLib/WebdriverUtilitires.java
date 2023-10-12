package genericLib;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtilitires 
{
	
	public void dropDown(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.scrollToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public void DrogAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}
	
	public void switchFromes(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}
	
	public void alertPopUp(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchTabs(WebDriver driver)
	{
		Set<String> child=driver.getWindowHandles();
		
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}
	
	public void scrollBar(WebDriver driver,int x,int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("windows.scrollBy("+x+","+y+")");
	}


}
