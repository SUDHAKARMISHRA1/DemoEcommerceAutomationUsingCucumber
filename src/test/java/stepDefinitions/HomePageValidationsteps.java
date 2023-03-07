package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.CartScreenModel;
import models.HomePageModel;
import models.ProductDetailsModel;
import pageObjects.CartScreen;
import pageObjects.CheckoutScreen;
import pageObjects.HomePage;
import pageObjects.ProductDetails;
import testComponents.BaseTest;
import testComponents.FetchTestDataFromExcelSheet;

public class HomePageValidationsteps extends BaseTest {

	public HomePage homepage;
	public ProductDetails proddetails;
	public CartScreen cart;
	public CheckoutScreen checkout;
	public String sheetname = "HomePage";

	HomePageModel HPM = new HomePageModel();
	ProductDetailsModel PDM = new ProductDetailsModel();
	CartScreenModel CSM = new CartScreenModel();
	FetchTestDataFromExcelSheet fData = new FetchTestDataFromExcelSheet();

	@Given("User open the Browser and Navigated to the Application Url")
	public void user_open_the_browser_and_navigated_to_the_application_url() throws IOException {
		homepage = launchApplication();

	}

	@When("User click on Shop Menu")
	public void user_click_on_shop_menu() {
	
		homepage.clickOnShopLink();
	}

	@When("Now click on Home menu button")
	public void now_click_on_home_menu_button() {
		homepage.clickOnHomeLink();
	}

	@Then("User should redirected to the home screen")
	public void user_should_redirected_to_the_home_screen() throws IOException {
		String actualHeading = homepage.getScreenHeading();
		String expectedHeading = fData.fetch_testdata("TC_01", sheetname);
		HPM.setHeadingHomeScreen(expectedHeading);
		try {
			assertEquals(actualHeading, HPM.getHeadingHomeScreen());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Then("Test whether the Home page has Three Sliders only")
	public void test_whether_the_home_page_has_three_sliders_only() throws IOException {
		int actualsize = homepage.getSliderSize();
		String expectedSliderCount = fData.fetch_testdata("TC_02", sheetname);
		HPM.setSliderCount(expectedSliderCount);
		try {
			assertEquals(actualsize, Integer.parseInt(HPM.getSliderCount()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("Test whether the Home page has Three Arrivals only")
	public void test_whether_the_home_page_has_three_arrivals_only() throws IOException {
		int actualsize = homepage.getArrivalCount();
		String expectedArrivalCount = fData.fetch_testdata("TC_03", sheetname);
		HPM.setArrivalCount(expectedArrivalCount);
		try {
			assertEquals(actualsize, Integer.parseInt(HPM.getArrivalCount()));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Now click the image in the Arrivals")
	public void now_click_the_image_in_the_arrivals() {
		proddetails = homepage.clickOnProduct();
	}

	@Then("Test whether it is navigating to next page where the user can add that book into his basket")
	public void test_whether_it_is_navigating_to_next_page_where_the_user_can_add_that_book_into_his_basket() throws IOException {
		String actualTitle = proddetails.getProductTitle();
		String expectedProductTitle = fData.fetch_testdata("TC_04", sheetname);
		PDM.setProductTitle(expectedProductTitle);
		try {
			assertEquals(actualTitle, PDM.getProductTitle());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("There should be a description regarding that book the user clicked on")
	public void there_should_be_a_description_regarding_that_book_the_user_clicked_on() throws IOException {
		String actualDesc = proddetails.getProductDescription();
		String expectedProductDesc = fData.fetch_testdata("TC_05", sheetname);
		PDM.setProductDescription(expectedProductDesc);
		try {
			assertEquals(actualDesc, PDM.getProductDescription());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Now click on Reviews tab for the book you clicked on")
	public void now_click_on_reviews_tab_for_the_book_you_clicked_on() {
		proddetails.clickOnReview();
	}

	@When("There should be a Reviews regarding that book the user clicked on")
	public void there_should_be_a_reviews_regarding_that_book_the_user_clicked_on() throws IOException {
		String actualReview = proddetails.getProductReviews();
		String expectedProductReview = fData.fetch_testdata("TC_06", sheetname);
		PDM.setProductReviews(expectedProductReview);
		try {
			assertEquals(actualReview, PDM.getProductReviews());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Click on the Add To Basket button which adds that book to your basket")
	public void click_on_the_add_to_basket_button_which_adds_that_book_to_your_basket() {
		homepage.addProductToCart();
	}

	@Then("User can view that Book in the Menu item with price")
	public void user_can_view_that_book_in_the_menu_item_with_price() throws IOException {
		String actualpriceandcount = homepage.getProductCountAndPrice();
		String[] CleanData = actualpriceandcount.replaceAll("[^0-9,., ]", "").split(" ");
		String actualProductCount = CleanData[0];
		String actualProductPrice = CleanData[1];
		String expectedProductCount = fData.fetch_testdata("TC_08", sheetname);
		String expectedProductPrice = fData.fetch_testdata("TC_09", sheetname);
		PDM.setProductCount(expectedProductCount);
		PDM.setProductPrice(expectedProductPrice);
		try {
			assertEquals(actualProductCount, PDM.getProductCount());

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			assertEquals(actualProductPrice, PDM.getProductPrice());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	int stockCounts = 0;

	@When("check the number of available stocks")
	public void check_the_number_of_available_stocks() {
		String stockData = proddetails.getStocksCount();
		String[] splittedData = stockData.split(" ");
		String value = splittedData[0];
		stockCounts = Integer.parseInt(value);
		System.out.println(stockCounts);
		PDM.getTotalStock();
		try {
			assertEquals(stockCounts, PDM.getTotalStock());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Select more books than the books in stock.")
	public void select_more_books_than_the_books_in_stock() throws InterruptedException {
		int value = stockCounts + 1;
		String sendrequiredStock = String.valueOf(value);
		proddetails.productCount(sendrequiredStock);

	}

	@Then("Now it throws an error prompt like you must enter a value between {string} and {string}")
	public void now_it_throws_an_error_prompt_like_you_must_enter_a_value_between_and(String string, String string2) {
		System.out.println("Find how to automate Flash mesage");
	}

	@When("Now click on Item link which navigates to proceed to check out page")
	public void now_click_on_item_link_which_navigates_to_proceed_to_check_out_page() {
		cart = homepage.cartDetails();
	}

	@Then("User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page")
	public void user_can_click_on_the_item_link_in_menu_item_after_adding_the_book_in_to_the_basket_which_leads_to_the_check_out_page() {
		String actualcartscreenheading = cart.getCartScreenHeading();
		System.out.println(actualcartscreenheading);
		CSM.setHeadingCartScreen("");
		try {
			assertEquals(actualcartscreenheading, CSM.getHeadingCartScreen());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Enter the Coupon code as {string} to get '50rps' off on the total")
	public void enter_the_coupon_code_as_to_get_50rps_off_on_the_total(String couponCode) {
		cart.addCoupon(couponCode);
	}

	@Then("Click on apply coupon button")
	public void Click_on_apply_coupon_button() {
		cart.applyCoupon();
	}

	@Then("User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give {string} off on the total price")
	public void user_can_able_to_apply_coupon_by_entering_krishnasakinala_in_the_coupon_textbox_which_give_off_on_the_total_price(
			String string) throws InterruptedException {
		Thread.sleep(1000);
		String actualappliedCouponName = cart.getAppliedCouponName();
		System.out.println(actualappliedCouponName);
		CSM.setAppliedCoupon("");
		try {
			assertEquals(actualappliedCouponName, CSM.getAppliedCoupon());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give {string} off on the total price because the coupon is applicable for the book price > {string}")
	public void user_can_not_able_to_apply_coupon_by_entering_krishnasakinala_in_the_coupon_textbox_which_give_off_on_the_total_price_because_the_coupon_is_applicable_for_the_book_price(
			String string, String string2) {
		String actualerrormsg = cart.getErrorMessage();
		System.out.println(actualerrormsg);
		CSM.setFailedErrorCoupon("");
		try {
			assertEquals(actualerrormsg, CSM.getFailedErrorCoupon());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("Now click on Remove this icon in Check out page which removes that book from the grid")
	public void now_click_on_remove_this_icon_in_check_out_page_which_removes_that_book_from_the_grid() {
		cart.removeItem();

	}

	@Then("User has the feasibility to remove the book at the time of check out also")
	public void user_has_the_feasibility_to_remove_the_book_at_the_time_of_check_out_also()
			throws InterruptedException {
		Thread.sleep(3000);
		String actualalertmsg = cart.getRemoveItemAlert();
		System.out.println(actualalertmsg);
		CSM.setRemoveAlertMessage("");
		try {
			assertEquals(actualalertmsg, CSM.getRemoveAlertMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Then("Click on textbox value under quantity in Check out page to add or subtract books {string}")
	public void click_on_textbox_value_under_quantity_in_check_out_page_to_add_or_subtract_books(String Quantity) {
		CSM.setProductQuantity(Quantity);
		cart.updateProductQuantity(CSM.getProductQuantity());
	}

	@When("Now click on Update Basket to reflect those changes")
	public void now_click_on_update_basket_to_reflect_those_changes() throws InterruptedException {
		Thread.sleep(2000);
		cart.updateCart();
	}

	@Then("User has the feasibility to Update Basket at the time of check out")
	public void user_has_the_feasibility_to_update_basket_at_the_time_of_check_out() {
		String actualprodcount = cart.getProductQuantity();
		System.out.println(actualprodcount);
		CSM.setProductQuantity("12");
		try {
			assertEquals(actualprodcount, CSM.getProductQuantity());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("Now User can find the Total price of the book in the Check out grid")
	public void now_user_can_find_the_total_price_of_the_book_in_the_check_out_grid() {
		String actualBillAmount = cart.getTotalBillAmount();
		System.out.println(actualBillAmount);
		CSM.setTotalAmount(9);
		try {
			assertEquals(Integer.parseInt(actualBillAmount), CSM.getTotalAmount());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("Now user can find total and subtotal values just above the Proceed to Checkout button")
	public void now_user_can_find_total_and_subtotal_values_just_above_the_proceed_to_checkout_button() {
		String actualsubtotal = cart.getSubTotalBillAmount();
		System.out.println(actualsubtotal);
		CSM.setSubTotal(9);
		try {
			assertEquals(Integer.parseInt(actualsubtotal), CSM.getSubTotal());
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Then("The total always < subtotal because taxes are added in the subtotal")
	public void the_total_always_subtotal_because_taxes_are_added_in_the_subtotal() {
		String totalamount = cart.getTotalBillAmount();
		String subtotal = cart.getSubTotalBillAmount();
		System.out.println(totalamount);
		System.out.println(subtotal);
		if (Integer.parseInt(totalamount) <= Integer.parseInt(subtotal)) {
			System.out.println("Failing Here for Total Amount on Comparision with SubTotal Amount");
		}

	}

	@When("Now click on Proceed to Check out button which navigates to payment gateway page")
	public void now_click_on_proceed_to_check_out_button_which_navigates_to_payment_gateway_page() {
		checkout = homepage.proceedToCheckout();

	}

	@Then("Clicking on Proceed to Checkout button leads to payment gateway page")
	public void clicking_on_proceed_to_checkout_button_leads_to_payment_gateway_page() {
		String actualHeading = checkout.getBillingScreenHeading();
		System.out.println(actualHeading);
	}

	@Then("User can view Billing Details,Order Details,Additional details and Payment gateway details")
	public void user_can_view_billing_details_order_details_additional_details_and_payment_gateway_details() {
		String actualFirstName = checkout.getFirstName();
		System.out.println(actualFirstName);
		String actulLastName = checkout.getLastName();
		System.out.println(actulLastName);
		String actualCompName = checkout.getCompanyName();
		System.out.println(actualCompName);
		String actualEmail = checkout.getEmail();
		System.out.println(actualEmail);
		String actualPhone = checkout.getPhone();
		System.out.println(actualPhone);
		String actualAddressOne = checkout.getAddressOne();
		System.out.println(actualAddressOne);
		String actualAddressTwo = checkout.getAddressTwo();
		System.out.println(actualAddressTwo);
		String actualCity = checkout.getBillingCity();
		System.out.println(actualCity);
		String actualPostCode = checkout.getPostCode();
		System.out.println(actualPostCode);
		String actualComments = checkout.getComments();
		System.out.println(actualComments);
	}

	@When("Now user can fill his details in billing details form like {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal")
	public void now_user_can_fill_his_details_in_billing_details_form_like_and_can_opt_any_payment_in_the_payment_gateway_like_direct_bank_transfer_cheque_cash_or_paypal(
			String fname, String lname, String comp, String email, String password, String phone, String country,
			String addressone, String addresstwo, String city, String statename, String code, String comments)
			throws InterruptedException {
		checkout.setFirstName(fname);
		checkout.setLastName(lname);
		checkout.setCompanyName(comp);
		checkout.setEmail(email);
		checkout.setPhone(phone);
		checkout.setAddressOne(addressone);
		checkout.setAddressTwo(addresstwo);
		checkout.setBillingCity(city);
		checkout.setPostCode(code);
		checkout.setComments(comments);
		checkout.checkCreateAccount();
		Thread.sleep(3000);
		checkout.setPass(password);
		checkout.setPayemetMode();
	}

	@When("Now click on Place Order button to complete process")
	public void now_click_on_place_order_button_to_complete_process() {
		// checkout.placeOrder();
	}

	@Then("On clicking place-order button user completes the process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.")
	public void on_clicking_place_order_button_user_completes_the_process_where_the_page_navigates_to_order_confirmation_page_with_order_details_bank_details_customer_details_and_billing_details() {

	}
	
	
	Scenario scn;
	@Before
	public void getScenario(Scenario sc) {
		this.scn = sc;
	}

	@AfterStep
	public void getScreenshotOfEachSteps(Scenario sc) throws IOException {
		if (sc.isFailed()) {
			HomePageValidationsteps.getScreenshot(sc,  driver);
		}
	}

	@After
	public void tearDown() {
		driver.close();
	}

	

}