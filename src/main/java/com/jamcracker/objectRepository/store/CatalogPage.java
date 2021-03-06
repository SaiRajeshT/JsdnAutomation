package com.jamcracker.objectRepository.store;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jamcracker.utilities.TestBase;

public class CatalogPage extends TestBase {
	
	public CatalogPage() {

		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(linkText="Catalog")
	public WebElement catalogLink;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement inCatalogCheckBox;
	
	@FindBy(id="save")
	public WebElement saveButton;
	
	@FindBy(id="saveData")
	public WebElement saveDataButton;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement cancelButton;
	
	@FindBy(xpath="//iframe[@name='_iframe-reqDiscount']")
	public WebElement addCredentialsFrame;
	
	@FindBy(xpath="//button[text()='Customise Catalog']")
	public WebElement customizeCatalogButton;
	
	@FindBy(xpath="//td[@id='retailPriceDIv']/input[@name='retailPrice']")
	public WebElement retailPriceTextBox;
	
	
	@FindBy(xpath="//form[@name='catalogForm']//img[@alt='Next']")
	public WebElement nextIcon;
	
	@FindBy(xpath="//form[@name='catalogForm']//img[@alt='Last']")
	public WebElement lastIcon;
	
	public WebElement getEditService(String offerName)
	{
		String objxpath="//tr[td[text()='"+offerName+"']]//td[4]//following-sibling::td[6]//img[@title='Edit']";
		//objxpath = objxpath.replaceAll("<REPLACE>", offerName);
		return getDriver().findElement(By.xpath(objxpath));
	}
	
	public boolean isEditServiceElementExist(String offerName)
	{
		try{
			String objxpath="//td[text()='<REPLACE>']//following-sibling::td[8]//img[@alt='Edit']";
			objxpath = objxpath.replaceAll("<REPLACE>", offerName);
			getDriver().findElement(By.xpath(objxpath));
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean isNextElementExist()
	{
		try{
			this.nextIcon.isDisplayed();
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
	public WebElement getresellStatus(String offerName)
	{
		String objxpath = "//tr[td[text()='<REPLACE>']]//td[4]//following-sibling::td[2]";
		objxpath = objxpath.replaceAll("<REPLACE>", offerName);
		return getDriver().findElement(By.xpath(objxpath));
	}
	
	@FindBy(id="searchValue")
	public WebElement searchTextBox;
	
	@FindBy(id="searchString")
	public WebElement searchStringDropDown;
	
	@FindBy(xpath="//button[contains(text(),'Go')]")
	public WebElement goButton;
	
	@FindBy(name="_iframe-consentDiv")
	 public WebElement consentFrame;
	 
	 @FindBy(xpath="//input[@value='Yes']")
	 public WebElement yesButton;
	 
	 @FindBy(xpath="//input[@value='No']")
	 public WebElement noButton;

}
