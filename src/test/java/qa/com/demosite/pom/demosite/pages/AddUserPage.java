package qa.com.demosite.pom.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage {
	
	@FindBy(name = "username")
	private WebElement username_inp;
	@FindBy(name = "password")
	private WebElement password_inp;
	@FindBy(name = "FormsButton2")
	private WebElement submit_btn;

	
	public AddUserPage(WebDriver driver) {
		super();
	}

	public void createUser(String username, String password) {
		username_inp.sendKeys(username);
		password_inp.sendKeys(password);
		submit_btn.click();
	}
	
	
}
