package testCases;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasePageClass;
import pages.LandingPage;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LandingPageTestCases {

	protected WebDriver driver;
	protected LandingPage landingpage;
	protected BasePageClass basepage;

	private WebDriver landingpage(WebDriver driver) {

		return null;
	}
//Method to be executed before each test
	// before each test case -- launch the browser
	// after each test case -- close the browser

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		{
			driver = new ChromeDriver();
			WebDriverManager.chromedriver().setup();
			driver.manage().window().maximize();
			driver.get("https://arielkiell.wixsite.com/interview");
			this.driver = landingpage(driver);
		}
	}

	@Test(priority = 1)
	public void ValidateUserWillAddBestSellerToCart() throws IOException {

		landingpage.gotoShop();
		landingpage.goToBestSeller();
		landingpage.selectBlack();
		landingpage.hoverOnArrow();
		landingpage.arrowUp(3);
		landingpage.addToCart();
		assertEquals(landingpage.getTotalCart(), "54");

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}

}
