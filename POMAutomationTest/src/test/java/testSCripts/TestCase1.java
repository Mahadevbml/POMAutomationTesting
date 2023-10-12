package testSCripts;

import org.testng.annotations.Test;

import genericLib.BaseClass;
import pomPages.AddToCart;
import pomPages.SkillraryDemoApplication;
import pomPages.SkillraryLoginPage;

public class TestCase1 extends BaseClass
{
	@Test
	public void tc1()
	{
		SkillraryLoginPage s=new SkillraryLoginPage(driver);
		s.gearsButton();
		s.skillraryDemoApplication();
		
		SkillraryDemoApplication d=new SkillraryDemoApplication(driver);
		drivervtilitires.switchTabs(driver);
		drivervtilitires.mouseHover(driver, d.getCoursetab());
		d.seleniumTrainingTab();
		
		AddToCart a=new AddToCart(driver);
		drivervtilitires.doubleClick(driver, a.getAddbutton());
		a.addToCartButton();
	}

}
