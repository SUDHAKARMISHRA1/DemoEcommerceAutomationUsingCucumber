package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin extends abstractComponents.AbstractComponent{

	WebDriver driver;

	public UserLogin(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	@FindBy(xpath="//h2[text()='Login']")
	WebElement Logintitle;

	@FindBy(id="username")
	WebElement Username;

	@FindBy(id="password")
	WebElement Password;

	@FindBy(xpath="//input[@type='submit' and @Value='Login']")
	WebElement Submit;
	

	public String getLoginScreenTitle() {
		String title = Logintitle.getText();
		return title;
	}

	public void enterUsername(String uname) {
		Username.sendKeys(uname);

	}

	public void enterPassword(String pass) {
		Password.sendKeys(pass);

	}
	public void clickonSubmitButton() {
		Submit.click();

	}


}
