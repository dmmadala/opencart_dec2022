package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;



public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test
	public void test_accountRegisration()
	{
		//logger.debug("Application logs...");
		logger.info("**************************************************");
		logger.info("************ Starting TC_001_AccountRegistrationTest *****************");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		
		logger.info("Clicking on My Account Link");
		hp.clickMyAccount();
		logger.info("Clicking on My Registration Link");
		logger.trace("capturing trace logs");
		logger.debug("capturing debug logs");
		hp.clickRegister();
		
		AccountRegistration regpage = new AccountRegistration(driver);
		logger.info("Providing customer Details");
		regpage.setFirstName(randomString());
		regpage.setLastName(randomString());
		regpage.setEmail(randomString()+"@gmail.com");
		
		regpage.setTelephone(randomNumber());
		String pwd = randomAlphaNumberic();
		regpage.setPassword(pwd);
		regpage.setConfirmPwd(randomString());
		
		regpage.clickPrivacyPolicy();
		
		logger.info("Clicking on Continue button");
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		
		logger.info("Verifying Customer Registration");
		
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
		 if(confmsg.equals("Your Account Has Been Created!")) 
		 	{
		 
			 logger.info("test passed ");
			 System.out.println("test passed");
		 		Assert.assertTrue(true); logger.info("test passed "); 
			 }
		  else 
		  	{
				
				// logger.warn("customer registration is not successful ");
				// logger.error("test failed "); 
				 
			  System.out.println("test Failed");
			  Assert.assertTrue(false);
	 
		  	}
		 
		
		}
		catch(Exception e) {			
			
			logger.warn("customer registration is not successful ");
			logger.error("test failed "); 
			 
			Assert.fail();
		}
		
		logger.info("************ Finished TC_001_AccountRegistrationTest ******************");
		
	}
		
	
	
}
