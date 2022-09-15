package stepDefinitions;

import org.junit.Assert;

import Factory.driverFactory;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginPageSteps {
	
	private static String title;
	private loginPage loginpage = new loginPage(driverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		driverFactory.getDriver().get("http://automationpractice.com/index.php");
		loginpage.clickOnSigninLink();

	}

	@When("user gets title of the page")
	public void user_gets_title_of_the_page() {
	    title = loginpage.checkLoginPageTitle();
	    System.out.println("Login Page Title is: "+title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
	    Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	    Assert.assertTrue(loginpage.checkForgotPwdLinkExists());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginpage.enterEmailID(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginpage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginpage.clickSigninBtn();
	}

	
	
	

}
