package testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginDataDriven extends BaseClass
{

	@Test(dataProvider="LoginData",groups= {"sanity","regression","master"})
	public void test_loginDDT(String email, String pwd, String exp) 
	{
		logger.info("Started... TC_003_LoginDataDriven");
		
		try
		{
			driver.get(rd.getString("Appurl"));
            logger.info("Home Page Displayed ");
			
			driver.manage().window().maximize();
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account ");
			hp.clickLogin();
			logger.info("Clicked login");
			
			LoginPage lp= new LoginPage(driver);
			lp.setInputEmail(email);
			logger.info("Email id provided");
			lp.setInputpwd(pwd);
			logger.info("Password provided");
			lp.click_login();
			logger.info("clicked login");
			
			boolean act_res = lp.isMyAccountPageExists();
			
			if(exp.equals("valid"))
			{
			 logger.info("Login Success");
			 MyAccountPage myaccpage= new MyAccountPage(driver);
			 myaccpage.clickLogout();
			 Assert.assertTrue(true);		 
		    }
			else
			{
				logger.error("Login Failed");
				Assert.assertFalse(true);
			}
			
			if(exp.equals("Invalid"))
			{
			 if(act_res==true)
			 {
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
			 }
			 else
			 {
					logger.error("Login Failed ");
				Assert.assertTrue(true);
			}
					
		}
	} catch(Exception e)
		{
		logger.fatal("Login Failed ");
		Assert.fail();
	}
	
	logger.info(" Finished TC_003_LoginDDT ");
	
}
   @DataProvider(name="LoginData")
   public String[][] getData() throws IOException
   {
	  String path = ".\\testData\\Opencart_LoginData.xlsx";
	  XLUtility xlutil=new XLUtility(path);
	  
	  int totalrows = xlutil.getRowCount("Sheet1");
	  int totalcols = xlutil.getCellCount("Sheet1", 1);
	  
	  String LoginData[][] = new String[totalrows][totalcols];
			  
			  for(int i=1;i<=totalrows;i++) //1
			  {
				  for(int j=0;j<totalcols;j++) //0 
				  {
					  LoginData[i-1][j]= xlutil.getCellData("Sheet1", i, j); //1,0
				  }
			  }
			return LoginData;
	   
   }
}
