package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	
	@BeforeClass
	public void setup() {
		
		//log4j2 code
		logger=LogManager.getLogger(this.getClass());
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\DivyaFolder\\SeleniumPT\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost/opencart/upload/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber()
	{
		String generateString = RandomStringUtils.randomNumeric(10);
		return generateString;
	}
	
	public String randomAlphaNumberic()
	{
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}

}
