package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	private WebDriver driver;
	
	//Webelements available on LoginPage 
	private By signInLink = By.linkText("Sign in");
	private By emailID = By.id("email");
	private By password = By.id("passwd");
	private By forgotPasswordLink = By.linkText("Forgot your password?");
	private By signInBtn = By.id("SubmitLogin");
	
	//Constructor to intia;ize webdriver
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods to action on the webelements
	public void clickOnSigninLink() {
		driver.findElement(signInLink).click();
	}
	
	public String checkLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterEmailID(String username) {
		driver.findElement(emailID).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public boolean checkForgotPwdLinkExists() {
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void clickSigninBtn() {
		driver.findElement(signInBtn).click();
	}
	
	public myAccountsPage doLogin(String un, String pwd) {
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		//page chaining(POM), if this action lands me on a different webpage, it needs to return that page's object
		return new myAccountsPage(driver);
	}
	
	

}
