package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
    
	@Test(groups= {"sanity","regression","master"})
	public void test_Login()
	{
		logger.info(" Starting TC_002_LoginTest ");
		
		try
		{
			driver.get(rd.getString("Appurl"));
			logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked on Login ");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setInputEmail(rd.getString("email"));
			logger.info("Provided Email ");
			
			lp.setInputpwd(rd.getString("password"));
			logger.info("Provided Password ");
			
			lp.click_login();
			logger.info("Clicked on Login");
			
			
			boolean targetpage=lp.isMyAccountPageExists();
			
			if(targetpage)
			{
				logger.info("Login Success ");
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Login Failed ");
				captureScreen(driver, "test_Login"); //Capturing screenshot
				Assert.assertTrue(false);
			}
		}	
		catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_Login ");
		
	}
	
	
}
   
