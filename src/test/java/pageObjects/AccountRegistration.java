package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage{

	public AccountRegistration(WebDriver driver) {
		super(driver);
	}

	
	//Elements
	@FindBy(name="firstname")
	WebElement txtFirstName;
	
	@FindBy(name="lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="telephone")
	WebElement txtTelephone;
	
	@FindBy(name="password")
	WebElement txtPwd;
	
	@FindBy(name="confirm")
	WebElement txtconfirmPwd;
	
	@FindBy(name="agree")
	WebElement chkdPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String FirstName)
	{
		txtFirstName.sendKeys(FirstName);
	}
	
	public void setLastName(String LastName)
	{
		txtLastName.sendKeys(LastName);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}	
	
	public void setPassword(String Pwd)
	{
		txtPwd.sendKeys(Pwd);
	}
	
	public void setConfirmPwd(String CnfmPwd)
	{
		txtconfirmPwd.sendKeys(CnfmPwd);
	}
	
	public void clickPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btn_Continue.click();
	}
	
	
	public String getConfirmationMsg()
	{
		try{
		return msgConfirmation.getText();
		}
	catch (Exception e) {
		return e.getMessage();
	}
		
	}
	
	
	
	
}
