package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myAccountsPage {
	
	
	//Page objects
	private WebDriver driver;
	//private List<WebElement> we;
	private By myAccountsSectios = By.cssSelector("div.row.addresses-lists span");
	
	//Constructor
	public myAccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Methods to perform actions on the page objects
	public String getMyAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public int getMyAccountsSectionsCount() {
		
		return driver.findElements(myAccountsSectios).size();
	}
	
	public List<String> getMyAccountsSectionsName() {
		List<WebElement> we = driver.findElements(myAccountsSectios);
		List<String> myAccountsSectionNames = new ArrayList<>();
		
		for(WebElement e: we) {
			String sectionName = e.getText();
			myAccountsSectionNames.add(sectionName);
		}
		return myAccountsSectionNames;
	}

}
