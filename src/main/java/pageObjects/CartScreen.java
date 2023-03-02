package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartScreen extends abstractComponents.AbstractComponent {

	WebDriver driver;

	public CartScreen(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cart_totals ']/h2 ")
	WebElement cartscreenheading;

	@FindBy(id = "coupon_code")
	WebElement coupon;

	@FindBy(css = "[name=apply_coupon]")
	WebElement applyCoupon;

	@FindBy(xpath = "//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[2]/th")
	WebElement appliedcouponname;

	@FindBy(xpath = "//ul[@class='woocommerce-error']/li")
	WebElement errormsg;

	@FindBy(linkText = "×")
	WebElement removeitem;

	@FindBy(css = "[class='cart-empty']")
	WebElement removeitemalert;

	@FindBy(css = "[pattern='[0-9]*']")
	WebElement updateproductcount;

	@FindBy(css = "[name='update_cart']")
	WebElement updatecart;

	@FindBy(xpath = "//tr[@class='order-total']/td/strong/span")
	WebElement totalprice;

	@FindBy(xpath = "//tr[@class='cart-subtotal']/td/span")
	WebElement subtotal;

	@FindBy(xpath = "//div[@class='wc-proceed-to-checkout']/a")
	WebElement proceedtocheckoutbutton;

	public String getCartScreenHeading() {
		String heading = cartscreenheading.getText();
		return heading;
	}

	public void addCoupon(String couponCode) {
		coupon.sendKeys(couponCode);
	}

	public void applyCoupon() {
		applyCoupon.click();
	}

	public String getAppliedCouponName() {
		String name = appliedcouponname.getText();
		return name;
	}

	public String getErrorMessage() {
		String couponerrormsg = errormsg.getText();
		return couponerrormsg;
	}

	public void removeItem() {
		removeitem.click();
	}

	public String getRemoveItemAlert() {
		String alertmsg = removeitemalert.getText();
		return alertmsg;
	}

	public void updateProductQuantity(String quantity) {
		updateproductcount.clear();
		updateproductcount.sendKeys(quantity);

	}

	public void updateCart() {
		updatecart.click();
	}

	public String getProductQuantity() {
		String count = updateproductcount.getText();
		return count;
	}

	public String getTotalBillAmount() {
		String price = totalprice.getText();
		return price;
	}

	public String getSubTotalBillAmount() {
		String price = subtotal.getText();
		return price;
	}

	public void proceedToCheckout() {
		proceedtocheckoutbutton.click();
	}

}
