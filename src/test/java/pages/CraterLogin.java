package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DataReader;
import utils.Driver;


public class CraterLogin {
	
	public CraterLogin() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	
	@FindBy(xpath = "//input[@name='email']")
	public WebElement Email;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passowrd;
	
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//span[text()='Amount Due']")
	public WebElement amountdueText;
	
	@FindBy(xpath = "//p[contains(text(), 'These credentials do not match our records.')]")
	public WebElement invalidUserErrorMessage;
	
	@FindBy(xpath = "//span[text()='Field is required']")
	public WebElement FieldrequiredError;

	
	public void login() {
		Email.sendKeys(DataReader.getData("validEmail"));;
		passowrd.sendKeys(DataReader.getData("passowrd"));
		
	}

}
