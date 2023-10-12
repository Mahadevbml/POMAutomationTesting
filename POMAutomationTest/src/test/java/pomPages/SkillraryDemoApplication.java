package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryDemoApplication 
{
	@FindBy(id="course")
	private WebElement coursetab;

	@FindBy(xpath="//a[text()='Selenium Training']")
	private WebElement seleniumtraining;
	
	public SkillraryDemoApplication(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//To generte getter an setter method
	//Select class->Right clik on class->Mosusehover to source->Clcik on Generate seetrs and Gettrs
	// Select coursetab tropdown->enable getCoursetab->Click on Generate
	public WebElement getCoursetab() {
		return coursetab;
	}
	
	public void seleniumTrainingTab()
	{
		seleniumtraining.click();
	}


}
