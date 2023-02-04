package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	
	private WebElement emailAddressfiels;
	
	@FindBy(xpath ="//input[@id='input-password']")
	private WebElement passwordfileds;
	
	@FindBy(xpath ="//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")
	private WebElement LoginButton;
	
	public void enterEmail(String emailText) {
		
		emailAddressfiels.sendKeys(emailText);
		
	}
	public void enterPassword(String passwordText) {
		
		passwordfileds.sendKeys(passwordText);
		
	}
	
	public AccountPage clickOnLoginButton() {
		
		LoginButton.click();
		
		return new AccountPage(driver);
		
	}

}
