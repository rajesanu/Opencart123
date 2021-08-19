package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistration;
import PageObjects.HomePage;
import testBase.BaseClass;

@Test(groups= {"sanity","regression","master"})
public class TC_001_AccountRegistration extends BaseClass 
{
	
   public void test_accounts_registration()
   {
	       try
	       {
	       logger.info(" Starting TC_001_AccountRegistration ");
	       
		   driver.get(rd.getString("Appurl"));
		   driver.manage().window().maximize();
		   
		   HomePage hp= new HomePage(driver);
		   hp.clickMyAccount();
		   logger.info("Clicked om Account Page");
		   hp.clickRegister();
		   logger.info("Clicked on Register Page");
		   
		   AccountRegistration reg= new AccountRegistration(driver);
		   reg.setFirstname("Raje");
		   logger.info("Firstname provided");
		   reg.setLastname("Madhan");
		   logger.info("Lastname provided");
		   reg.setEmail(randomString());		   
		   logger.info("Email provided");
		   reg.setPhone("1234567");
		   logger.info("Phone number provided");
		   reg.setPassword("Admin123");
		   logger.info("Password details provided");
		   reg.setConfirmPwd("Admin123");
		   logger.info("Confirm password provided");
		   reg.setPrivacyPolicy();
		   logger.info("Privacy policy accepted");
		   reg.ClickContinue();
		   logger.info("Continued the registration");
		   
		   String ConfMsg = reg.getConfirmMsg();
		   
			   if(ConfMsg.equals("Your Account Has Been Created!"))
					   {
						  Assert.assertTrue(true);
						  logger.info("Registration completed succesfully");
						 
					   }
			        else
			           {
				         logger.error("Account Registration failed");
				         captureScreen(driver,"test_accounts_registration"); // capturing screenshot
				         Assert.assertTrue(false);    
			           }
	       }
			           catch(Exception e)
			           {
			        	   logger.fatal("Account Registration failed");  
			        	   Assert.fail();
			           }
	       
	       logger.info("Finished TC_001_AccountRegistration");
   }
   
}

   
   
