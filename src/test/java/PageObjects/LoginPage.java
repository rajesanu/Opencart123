package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
   WebDriver driver;
   
   public LoginPage(WebDriver driver)
   {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
	
   @FindBy(xpath="//input[@id='input-email']")
   WebElement txt_inputemail;
   
   @FindBy(id="input-password")
   WebElement txt_inputpwd;
   
   @FindBy(xpath="//input[@value='Login']")
   WebElement btn_login;
   
   @FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
   
   public void setInputEmail(String email)
   {
	   txt_inputemail.sendKeys(email);
   }
   
   public void setInputpwd(String pwd)
   {
	   txt_inputpwd.sendKeys(pwd);
   }
   
   public void click_login()
   {
	   btn_login.click();
   }
   
   public boolean isMyAccountPageExists()
   {
   try
   {
	    return(msgHeading.isDisplayed());
   }
   catch(Exception e)
   {
	   return(false);
   }
   }
}

