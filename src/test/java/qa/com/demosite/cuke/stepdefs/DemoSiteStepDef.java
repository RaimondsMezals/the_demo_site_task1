package qa.com.demosite.cuke.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import qa.com.demosite.cuke.pom.DemoPortalPage;

public class DemoSiteStepDef {

	private static RemoteWebDriver driver;
	private static WebElement targ;

	public static ChromeOptions chromeCfg() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		ChromeOptions cOptions = new ChromeOptions();

		// Settings
		prefs.put("profile.default_content_setting_values.cookies", 2);
		prefs.put("network.cookie.cookieBehavior", 2);
		prefs.put("profile.block_third_party_cookies", true);

		// Create ChromeOptions to disable Cookies pop-up
		cOptions.setExperimentalOption("prefs", prefs);

		return cOptions;
	}

	@Before
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver(chromeCfg());
		System.out.println("Tests have Started");

	}

	@After
	public static void cleanUp() {
		driver.quit();
		System.out.println("The driver has been closed!");
	}

	@Given("^I can access \"([^\"]*)\"$")
	public void i_can_access(String arg1) throws Throwable {
		driver.get("http://" + arg1);
	}

	@When("^I go to the add user page$")
	public void i_go_to_the_add_user_page() throws Throwable {
		DemoPortalPage website = PageFactory.initElements(driver, DemoPortalPage.class);
		website.navigateAddUser();
	}

	@When("^Enter my user credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void enter_my_user_credentials(String arg1, String arg2) throws Throwable {
		DemoPortalPage website = PageFactory.initElements(driver, DemoPortalPage.class);
		website.addUserPage.createUser(arg1, arg2);
	}

	@When("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Throwable {
		DemoPortalPage website = PageFactory.initElements(driver, DemoPortalPage.class);
		website.navigateLoginUser();
	}

	@When("^I enter my login credentials \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_enter_my_login_credentials(String arg1, String arg2) throws Throwable {
		DemoPortalPage website = PageFactory.initElements(driver, DemoPortalPage.class);
		website.loginUserPage.loginUser(arg1, arg2);
	}

	@Then("^I should have successfully logged in$")
	public void i_should_have_successfully_logged_in() throws Throwable {
		DemoPortalPage website = PageFactory.initElements(driver, DemoPortalPage.class);
		String result = website.loginUserPage.getStatus();

		assertEquals("**Successful Login**", result);
	}

}
