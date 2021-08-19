package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration 
{

	WebDriver driver;
	
	public AccountRegistration(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	WebElement txtFirstname;
	
	@FindBy(name="lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtphone;
	
	@FindBy(id="input-password")
	WebElement txtpwd;
	
	@FindBy(id="input-confirm")
	WebElement txtconfimPwd;
	
    @FindBy(name="agree")
    WebElement chkdPolicy;
   
    @FindBy(xpath="//input[@value='Continue']")
    WebElement BtnContinue;
   
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;
    
    public void setFirstname(String fname)
    {
    	txtFirstname.sendKeys(fname);
    	
    }

    public void setLastname(String lname)
    {
    	txtLastname.sendKeys(lname);
    	
    }
    
    public void setEmail(String email)
    {
    	txtEmail.sendKeys(email);
    }
    
    public void setPhone(String tel)
    {
    	txtphone.sendKeys(tel);
    }
    
    public void setPassword(String pwd)
    {
        txtpwd.sendKeys(pwd);

    }
    public void setConfirmPwd(String CPwd)
    {
       txtconfimPwd.sendKeys(CPwd);
    }
    
    public void setPrivacyPolicy()
    {
    	chkdPolicy.click();
    }
    
    public void ClickContinue()
    {
       BtnContinue.click();
    }

    public String getConfirmMsg()
    {
    	try
    	{
    	 return (msgConfirmation.getText());
    	}
    	
    	catch(Exception e)
    	{
    		return(e.getMessage());
    	}
    }
    
    
    
    
}


