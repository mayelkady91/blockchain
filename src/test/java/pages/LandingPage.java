package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePageClass {

	protected WebDriver driver;
	public LandingPage landingPage = new LandingPage(driver);
//Constructor 

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Page Locators

	// Shop button

	WebElement sshop = driver.findElement(By.id("comp-iy4cwgmq1label"));

	// Best Seller

	WebElement BestSeller = driver
			.findElement(By.cssSelector("img[src='697bc8_49306eb7e4674636bf3a12f3364f8cbf~mv2_d_3000_1744_s_2.jpg']"));

	// Black Color

	WebElement BlackColor = driver
			.findElement(By.xpath("//div[@class=\"sndC458\" AND @style=\"background-color: rgb(0, 0, 0);\"]"));

	// Arrow container
	WebElement ArrowContainer = driver
			.findElement(By.xpath("//div[@data-hook=\"number-input-spinner-arrows-container\" AND @class=\"CupGjl\"]"));

	// ArrowUp
	WebElement ArrowUp = driver
			.findElement(By.xpath("//span[@data-hook=\"number-input-spinner-up-arrow\" AND @class=\"bzZYud\"]"));

	// Add to Cart
	WebElement AddtoCart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));

	// Cart Total price
	WebElement CartTotal = driver
			.findElement(By.xpath("//button[@class=\"sCyrwfb soKBvhV sw6fryq oppNbDj--fullWidth sbJCf6d stuIsqZ\"]"));

	// Methods declaration
//Method to click on shop 
	public void gotoShop() {

		sshop.click();

	}

//Method to Add item to cart
	public void addToCart() {
		AddtoCart.click();
	}

//Method to hover on input box for arrow to be displayed 
	public void hoverOnArrow() {
		Actions action = new Actions(driver);
		action.moveToElement(ArrowContainer).perform();

	}

//Method with input NumofClick = x to add x items to cart
	public void arrowUp(int NumOfClick) {

		for (int i = 0; i < NumOfClick; i++) {
			// ArrowUp.click();
		}
	}

//Method to click on black color 
	public void selectBlack() {
		BlackColor.click();

	}

//Method to scroll down until object is inview then clicks on it
	public void goToBestSeller() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BestSeller);
		BestSeller.click();

	}

	public String getTotalCart() {
		return CartTotal.getText();

	}

}
