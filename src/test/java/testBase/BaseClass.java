package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
   public WebDriver driver;
   public Logger logger; // for logging
   public ResourceBundle rd; // to read config.properties
   
   @BeforeClass(groups= {"sanity","regression","master"})
   @Parameters({"browser"})
   public void Setup(String b1)
   {
	   
	   //Load the config properties
	   rd = ResourceBundle.getBundle("config");
	   
	   //Logging
	   logger= LogManager.getLogger(this.getClass());
	   
	   //driver
	   if(b1.equals("chrome"))
	   {
	   WebDriverManager.chromedriver().setup();
	   driver= new ChromeDriver();
	   logger.info("Chrome driver is launched");
	   }
	   else if (b1.equals("Edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		   driver = new EdgeDriver();
		   logger.info("Edge driver is launched");
	   }
	   else if(b1.equals("FireFox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver = new FirefoxDriver();
		   logger.info("Firefox driver is launched");
	   }
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
   }
   
   @AfterClass(groups= {"sanity","regression","master"})
   public void tearDown()
   {
	   driver.quit();
   }
   
   public String randomString()
   {
	String generatedString= RandomStringUtils.randomAlphabetic(4);
	String generarednumeric = RandomStringUtils.randomNumeric(3);
	return (generatedString + Integer.parseInt(generarednumeric)+ "@gmail.com");   
   }
   
   public int randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));
   }	

	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		// Convert web driver object to TakeScreenshot
		TakesScreenshot ts= (TakesScreenshot) driver;
		//Call getScreenshot method to create image file
		File Source = ts.getScreenshotAs(OutputType.FILE);
	    // Move image file into new destination path
		File target = new File(System.getProperty("user.dir") + "\\screenshot\\" + tname + ".png");
		// copy the source file to destination
		FileUtils.copyFile(Source, target);
	}
	
	}
