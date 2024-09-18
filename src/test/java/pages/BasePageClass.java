package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import Utils.Utils;

public class BasePageClass {
	// Initializing driver

	public BasePageClass basePage;

	protected WebDriver driver;

	public BasePageClass() {

	}

	public BasePageClass(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// AfterMethod annotation - This method executes after every test execution

	@AfterMethod
	public void screenShot(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				Utils util = new Utils(driver);
				util.takeScreenShot();
			} catch (Exception exception) {
				System.out.println(exception.toString());
			}
		} else {
			Utils util = new Utils(driver);
			util.takeScreenShot();
		}

	}

// AfterTest annotation - This method executes after all @Test annotations are done
	@AfterTest()
	public void afterTest() {
		driver.quit();
	}
}
