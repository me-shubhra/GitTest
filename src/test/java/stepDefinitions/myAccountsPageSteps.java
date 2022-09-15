package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import Factory.driverFactory;
import Pages.loginPage;
import Pages.myAccountsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class myAccountsPageSteps {
	
	private loginPage loginpage = new loginPage(driverFactory.getDriver());
	private myAccountsPage myaccpage;
	
	@Given("user is already logged into the application")
	public void user_is_already_logged_into_the_application(DataTable credentialsTable) {
		System.out.println("Datatable values in features file : "+credentialsTable.cell(0, 0)+" "+credentialsTable.cell(0, 1));
	    List<Map<String, String>> credentials = credentialsTable.asMaps();
	    String username = credentials.get(0).get("username");
	    String pwd = credentials.get(0).get("password");
	    driverFactory.getDriver().get("http://automationpractice.com/index.php");
	    loginpage.clickOnSigninLink();
	    myaccpage = loginpage.doLogin(username, pwd);

	}

	@Given("user is on My Accounts page")
	public void user_is_on_my_accounts_page() {
		String title = myaccpage.getMyAccountsPageTitle();
		System.out.println("MyAccounts Page title: "+title);
	}

	@Then("user gets My Accounts section")
	public void user_gets_my_accounts_section(DataTable myaccsectionsTable) {
		List<String> expmyaccsections = myaccsectionsTable.asList();
		
		List<String> actualmyaccsections = myaccpage.getMyAccountsSectionsName();
		Assert.assertTrue(actualmyaccsections.containsAll(expmyaccsections));
	    

	}

	@Then("My Accounts section count should be {int}")
	public void my_accounts_section_count_should_be(Integer expmyaccsectionscount) {
	   Assert.assertTrue(myaccpage.getMyAccountsSectionsCount() == expmyaccsectionscount);

	}

}
