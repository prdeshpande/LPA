package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Utilities.Element;
import Utilities.InputData;
import Controller.Illustration;
import Controller.Login;
import static org.junit.Assert.fail;
//import org.openqa.selenium.chrome.*;
//import org.openqa.selenium.firefox.FirefoxDriver;

//@SuppressWarnings("unused")
@SuppressWarnings("unused")
@RunWith (value = Parameterized.class)

public class LPATest {
	
	private static WebDriver driver;
	private static StringBuffer verificationErrors = new StringBuffer();
	private static Element objMap;
	private static List<Element> list;
	
	public LPATest(Element obj){
		LPATest.objMap = obj;
	}
	
	//Non-Model source file
	//private static String sourceFile = "C:\\lpa\\Non_ModelStates.csv";
	private static String sourceFile = "C:\\lpa\\ageInput.csv";
	
	
			
	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection testData() throws IOException{
		LPATest.list = InputData.getTestData(sourceFile);
		return LPATest.list;
		}
	

	@BeforeClass
	public static void setup() throws Exception{
	    	//ChromeOptions options = new ChromeOptions();
	    	//options.setBinary("/Library/Selenium/SeleniumDrivers/chromedriver");
	       
	    	//Setting up for chrome browser
	    	//System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	        //driver = new ChromeDriver();
	        
	         
	    	// Setting for Firefox Browser
	        //driver = new FirefoxDriver();
	    	
	    	// Setting up the IE browser
	    	System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
			//url
			driver.get("https://lpab1.hoad.local/LifePortraits.aspx#");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,java.util.concurrent.TimeUnit.SECONDS);
			
			//clicking through error when using IE
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");			
			
			Login oLogin = new Login(driver);
			oLogin.doLogin();
	}
	
	
	@Test
	public void lpa_Test() throws Throwable {
		Illustration newIllustration = new Illustration();
		newIllustration.createIllustration(driver, LPATest.objMap);
		}
	
	
	@AfterClass
	public static void tearDown() throws Exception{
		//driver.close();
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)){
			fail(verificationErrorString);
		}
	}
	
	
}
