package Controller;

import POM.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



@SuppressWarnings("unused")
public class Login {

	private WebDriver driver;
	
	public Login(WebDriver driver){
		this.driver = driver;
	}
	
	public void doLogin() throws InterruptedException{
	//driver.findElement(By.id("continueToSite")).click();
	
	Thread.sleep(3000);
		
	LoginPage objLoginPage = new LoginPage(driver);
	objLoginPage.get();
	
	try{
		//logging in
		boolean displayID = false;
		displayID = (new WebDriverWait (driver, 3)).until(new ExpectedCondition<Boolean>(){ 
			public Boolean apply(WebDriver d){
				return objLoginPage.userName.isDisplayed();
			}});
		if (displayID){objLoginPage.userName.clear();
					   objLoginPage.userName.sendKeys("bks7234");}
		
		if((new WebDriverWait (driver,3)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
				return objLoginPage.pwd.isDisplayed();
			}}))
		{ objLoginPage.pwd.clear();
		  objLoginPage.pwd.sendKeys("wdmb1");}
		
		else{
			System.out.println("Password field does not exist");}
		
		boolean displayLoginBtn = false;
		displayLoginBtn = (new WebDriverWait (driver,3)).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver d){
				return objLoginPage.btnLogin.isDisplayed();
			}});
		if (displayLoginBtn){objLoginPage.btnLogin.click();}}
	
		catch (Exception e){
			boolean displayLoginBtn = false;
			displayLoginBtn = (new WebDriverWait (driver,3).until(new ExpectedCondition<Boolean>(){
				public Boolean apply(WebDriver d){
					return objLoginPage.btnLogin.isDisplayed();}}));
			if(displayLoginBtn){objLoginPage.btnLogin.click();}
				}
	Thread.sleep(3000);
	}
}
