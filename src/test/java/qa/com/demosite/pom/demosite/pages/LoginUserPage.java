package qa.com.demosite.pom.demosite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUserPage {
	
	@FindBy(name = "username")
	private WebElement username_inp;
	@FindBy(name = "password")
	private WebElement password_inp;
	@FindBy(name = "FormsButton2")
	private WebElement submit_btn;
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement status_txt;
	
	public LoginUserPage(WebDriver driver) {
		super();
	}

	public void loginUser(String username, String password) {
		username_inp.sendKeys(username);
		password_inp.sendKeys(password);
		submit_btn.click();
	}
	
	public String getStatus() {
		return status_txt.getText();
	}
	
}
