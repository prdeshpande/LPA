package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class LoginPage extends LoadableComponent<LoginPage> {
	
	private WebDriver driver;
	private String title = "Login";
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userName")
	public WebElement userName;
	
	@FindBy(id="pwd")
	public WebElement pwd;
	
	@FindBy(id="btnLogin")
	public WebElement btnLogin;
	
	@Override
	protected void isLoaded() throws Error{
		System.out.println(driver.getTitle().toString());
		assertTrue(driver.getTitle().equals(title));
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
