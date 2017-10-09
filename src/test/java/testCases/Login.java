package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Base64;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class Login {
	
	private static WebDriver driver=null;
	
	@Test
	public void Test1() throws InterruptedException 
	{
		
		driver.get("https://login.salesforce.com");
		//driver.manage().window().maximize();
		driver.findElement(By.id("login_form")).sendKeys("salesforce.devops@optum.com");
		driver.findElement(By.id("password")).sendKeys("Aug<2017");
		driver.findElement(By.id("Login")).submit();
		Thread.sleep(25000);
		WebDriverWait wait = new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//button[@class='bare slds-button uiButton forceHeaderButton oneUserProfileCardTrigger']")));
		driver.findElement(By.xpath("//button[@class='bare slds-button uiButton forceHeaderButton oneUserProfileCardTrigger']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//a[@href='/secur/logout.jsp']")));
		System.out.println("success");
		driver.findElement(By.xpath("//a[@href='/secur/logout.jsp']")).click();
		System.out.println("logout");
}
	
	@Before
	  public void beforeTest() {
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sde100\\shalini\\com.Pilot\\GDriver\\geckodriver.exe");
		driver = new FirefoxDriver(capabilities); 

	  }

	  @After
	  public void afterTest() {
		//  driver.quit();
	  }
}
