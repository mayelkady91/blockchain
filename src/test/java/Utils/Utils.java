package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class Utils {
	WebDriver driver;

	public Utils() {

	}

	public Utils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Method for screenshots after each step
	public void takeScreenShot() throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
		String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(screenshotFile, DestFile);
	}

}