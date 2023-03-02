package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetails extends abstractComponents.AbstractComponent {

	WebDriver driver;

	public ProductDetails(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[itemprop='name']")
	WebElement producttitle;

	@FindBy(xpath = "//div[@class='layoutArea']/div/p")
	WebElement productdesc;

	@FindBy(xpath = "//*[@id='product-165']/div[3]/ul/li[2]/a")
	WebElement reviewlink;

	@FindBy(xpath = "//div[@id='comments']/p")
	WebElement review;

	@FindBy(xpath = "//p[@class='stock in-stock']")
	WebElement stockscount;

	@FindBy(css = "[type='number']")
	WebElement productcount;

	public String getProductTitle() {
		String title = producttitle.getText();
		return title;
	}

	public String getProductDescription() {
		String desc = productdesc.getText();
		return desc;
	}

	public void clickOnReview() {
		reviewlink.click();
	}

	public String getProductReviews() {
		String reviews = review.getText();
		return reviews;
	}

	public String getStocksCount() {
		String stockcount = stockscount.getText();
		return stockcount;
	}

	public void productCount(String ProdCount) {
		productcount.clear();
		productcount.sendKeys(ProdCount);
	}

}
