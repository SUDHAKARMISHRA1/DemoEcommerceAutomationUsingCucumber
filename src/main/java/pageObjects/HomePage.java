package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends abstractComponents.AbstractComponent {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Shop")
	WebElement shoplink;

	@FindBy(linkText = "Home")
	WebElement homelink;

	@FindBy(xpath = "//*[text()= 'new arrivals']")
	WebElement screenheading;

	By slidersize = By.xpath("//div[@class='n2-ss-slider-3']/div");

	By totalarrivals = By.xpath("//div[@id='page-22']/div/div/div[2]/div/div/div/div/div[2]/div");

	@FindBy(xpath = "//img[@alt='Mastering JavaScript' and @title='Mastering JavaScript']")
	WebElement clickonproduct;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addproduct;

	@FindBy(xpath = "//li[@id='wpmenucartli']/a")
	WebElement productcountandcount;

	@FindBy(xpath = "//div[@class='wc-proceed-to-checkout']/a")
	WebElement proceedtocheckoutbutton;

	public void goTo() {
		driver.get("https://practice.automationtesting.in/");
	}

	public void clickOnShopLink() {

		shoplink.click();
	}

	public void clickOnHomeLink() {
		homelink.click();
	}

	public String getScreenHeading() {
		String heading = screenheading.getText();
		return heading;
	}

	public int getSliderSize() {
		return driver.findElements(slidersize).size();
	}

	public int getArrivalCount() {
		return driver.findElements(totalarrivals).size();
	}

	public ProductDetails clickOnProduct() {
		clickonproduct.click();
		ProductDetails proddetail = new ProductDetails(driver);
		return proddetail;
	}

	public void addProductToCart() {
		addproduct.click();
	}

	public String getProductCountAndPrice() {
		String menucartdetail = productcountandcount.getText();
		return menucartdetail;
	}

	public CartScreen cartDetails() {
		productcountandcount.click();
		CartScreen cart = new CartScreen(driver);
		return cart;
	}

	public CheckoutScreen proceedToCheckout() {
		proceedtocheckoutbutton.click();
		CheckoutScreen checkout = new CheckoutScreen(driver);
		return checkout;
	}

}
