package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CraterDashboardElements {
	
	public  CraterDashboardElements() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//a[contains(text(),' Items')]")
	public WebElement itembutton;

	
	@FindBy(xpath = "//button[text()= ' Add Item']")
	public WebElement addItemButton;
	
	@FindBy (xpath = "//h3[text()='New Item']")
	public WebElement itemsHeaderText;
	
	@FindBy (xpath = "//button[text()='Filter ']")
	public WebElement filterItemButton;
	
	@FindBy (xpath = "//div[@name='name']/input")
	public WebElement filterNameField;
	
	// add item window
		@FindBy (xpath = "//h3[text()='New Item']")
		public WebElement newItemHeaderText;

		@FindBy (xpath = "//div[@class='relative rounded-md shadow-sm font-base']/input")
		public WebElement addItemNameField;

		@FindBy (xpath = "//div[@class='flex flex-col mt-1']/input")
		public WebElement addItemPriceField;

		@FindBy (xpath = "(//div[@class='flex flex-col mt-1']/div/input)[2]")
		public WebElement addItemUnitField;

		@FindBy (xpath = "//textarea[@name='description']")
		public WebElement addItemDescription;

		@FindBy (xpath = "//button[text()=' Save Item']")
		public WebElement saveItemButton;

		@FindBy (xpath = "//span[text()='pc']")
		public WebElement pc_unit;

		@FindBy (xpath = "//p[text()='Item created successfully']")
		public WebElement itemCreateSuccessMessage;
		
		@FindBy(xpath = "//span[contains(text(), 'Amount Due')]")
		public WebElement amoutDueText;

}

