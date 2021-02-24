package qa.com.demosite.cuke.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.com.demosite.pom.demosite.pages.AddUserPage;
import qa.com.demosite.pom.demosite.pages.LoginUserPage;

public class DemoPortalPage {
	
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUser_lnk;
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginUser_lnk;
	
	public AddUserPage addUserPage;
	public LoginUserPage loginUserPage;
	
	public DemoPortalPage(WebDriver driver) {
		super();
		addUserPage = PageFactory.initElements(driver, AddUserPage.class);
		loginUserPage = PageFactory.initElements(driver, LoginUserPage.class);
	}

	public void navigateAddUser() {
		addUser_lnk.click();
	}
	public void navigateLoginUser() {
		loginUser_lnk.click();
	}
	
	
	
}
