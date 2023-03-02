package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutScreen extends abstractComponents.AbstractComponent {

	WebDriver driver;

	public CheckoutScreen(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class = 'woocommerce-billing-fields']/h3")
	WebElement billingscreenheading;

	@FindBy(id = "billing_first_name")
	WebElement fname;
	@FindBy(id = "billing_last_name")
	WebElement lname;
	@FindBy(id = "billing_company")
	WebElement compname;

	@FindBy(id = "billing_email")
	WebElement email;
	@FindBy(id = "account_password")
	WebElement password;

	@FindBy(id = "billing_phone")
	WebElement phone;
	@FindBy(id = "s2id_billing_country")
	WebElement Country;

	@FindBy(id = "billing_address_1")
	WebElement Address;
	@FindBy(id = "billing_address_2")
	WebElement Address2;
	@FindBy(id = "billing_city")
	WebElement Town;

	@FindBy(id = "s2id_billing_state")
	WebElement State;
	@FindBy(id = "billing_postcode")
	WebElement Postcode;
	@FindBy(id = "order_comments")
	WebElement comments;

	@FindBy(id = "payment_method_cod")
	WebElement paymenttype;
	@FindBy(id = "place_order")
	WebElement placeorder;
	@FindBy(id = "createaccount")
	WebElement createaccount;

	public String getBillingScreenHeading() {
		String heading = billingscreenheading.getText();
		return heading;
	}

	public void setFirstName(String firstname) {
		fname.sendKeys(firstname);
	}

	public void setLastName(String lastname) {
		lname.sendKeys(lastname);
	}

	public void setCompanyName(String comp) {
		compname.sendKeys(comp);
	}

	public void setEmail(String useremail) {
		email.sendKeys(useremail);
	}

	public void setPass(String pass) {
		password.sendKeys(pass);
	}

	public void setPhone(String userphone) {
		phone.sendKeys(userphone);
	}

	public void setCountry(String countryname) {
		Country.sendKeys(countryname);
	}

	public void setAddressOne(String addressone) {
		Address.sendKeys(addressone);
	}

	public void setAddressTwo(String addresstwo) {
		Address2.sendKeys(addresstwo);
	}

	public void setBillingCity(String city) {
		Town.sendKeys(city);
	}

	public void setState(String statename) {
		State.sendKeys(statename);
	}

	public void setPostCode(String code) {
		Postcode.sendKeys(code);
	}

	public void setComments(String usercomments) {
		comments.sendKeys(usercomments);
	}

	public void setPayemetMode() {
		paymenttype.click();
	}

	public void placeOrder() {
		placeorder.click();
	}

	public void checkCreateAccount() {
		createaccount.click();
	}
	
	public String getFirstName() {
		String Fname = fname.getText();
		return Fname;
	}

	public String getLastName() {
		String Lname = lname.getText();
		return Lname;
	}

	public String getCompanyName() {
		String Company= compname.getText();
		return Company;
	}

	public String getEmail() {
		String Email =email.getText();
		return Email;
	}
	
	public String getPhone() {
		String Phone = phone.getText();
		return Phone;
		
	}

	public String getCountry() {
		String CountryName= Country.getText();
		return CountryName;
	}

	public String getAddressOne() {
		String AddressOne= Address.getText();
		return AddressOne;
	}

	public String getAddressTwo() {
		String AddressTwo = Address2.getText();
		return AddressTwo;
	}

	public String getBillingCity() {
		String City =Town.getText();
		return City;
	}

	public String getState() {
		String StateName = State.getText();
		return StateName;
	}

	public String getPostCode() {
		String PostCode = Postcode.getText();
		return PostCode;
		
	}

	public String getComments() {
		String Comment= comments.getText();
		return Comment;
	}
	
}
