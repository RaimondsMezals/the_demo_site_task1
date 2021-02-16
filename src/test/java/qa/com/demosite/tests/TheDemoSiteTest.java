package qa.com.demosite.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import qa.com.demosite.pom.demosite.DemoPortalPage;
import qa.com.demosite.pom.demosite.pages.AddUserPage;
import qa.com.demosite.pom.demosite.pages.LoginUserPage;

public class TheDemoSiteTest {
	private static RemoteWebDriver driver;
	private static WebElement targ;

	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		driver = new ChromeDriver(chromeCfg());
		System.out.println("Tests have Started");

	}

	@AfterAll
	public static void cleanUp() {
		driver.quit();
		System.out.println("The driver has been closed!");
	}

	@BeforeEach
	public void before() {
		System.out.println("\nTest has started!");
	}

	@AfterEach
	public void after() {
		System.out.println("\nTest has finished!");
	}

	@Test
	public void test1() throws InterruptedException {

		// GIVEN - i can access thedemosite.com
		driver.get("http://thedemosite.co.uk/");
		
		DemoPortalPage website = PageFactory.initElements(driver, DemoPortalPage.class);


		// WHEN - i go to the add user page
		website.navigateAddUser();

		// AND - enter my user credentials
		website.addUserPage.createUser("guest", "guest");

		// AND - i navigate to the login page
		website.navigateLoginUser();

		// AND - enter my credentials

		website.loginUserPage.loginUser("guest", "guest");

		// THEN - i should have successfully logged in

		String result = website.loginUserPage.getStatus();

		assertEquals("**Successful Login**", result);

		System.out.println("test1 running");

		Thread.sleep(5000);
	}

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

}
