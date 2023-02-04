package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	
	private WebElement MyAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOpetion;
	
public void clickOnMyAccountDropMenu() {
	MyAccountDropMenu.click();
	
}
public LoginPage selectLoginOption() {
	
	loginOpetion.click();
	
	return new LoginPage(driver);
	
}
}
