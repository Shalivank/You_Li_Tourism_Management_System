package org.TMS.POMRepository;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
	@FindBy(xpath = "//h4[.='Package Name: mysuru palace']") private WebElement ScrollSpecifiedPackageName;
	@FindBy(xpath = "//h3[.='Package List']/ancestor::div[@class='room-bottom']//h4[.='Package Name: DummyPackage348']/../..//a[.='Details']")
	private WebElement ViewSpecifiedPackage;
	@FindBy(xpath = "//a[.='Tour Packages']") private WebElement clickOnTourPackagesTab;
	@FindBy(xpath = "//a[.='/ Logout']") private WebElement UserLogoutLink;
	@FindBy(xpath = "//a[.=' / Write Us ']") private WebElement writeUsLink;
	@FindBy(xpath = "//select[@name='issue']") private WebElement issueDropdown;
	@FindBy(xpath = "//input[@name='description']") private WebElement descriptionTextAreaField;
	@FindBy(xpath = "//button[@name='submit']") private WebElement submitButton;
	@FindBy(xpath = "//a[.='Issue Tickets']") private WebElement issueTicketsButton;
	
	public UserHomePage(WebDriver driver)
	{
		
    	PageFactory.initElements(driver, this);
	}
	
	 public void ScrollSpecifiedPackageName(WebDriver driver, WebDriverUtility wdu)
	    {
	    	wdu.initializeJSE(driver);
	    	wdu.scrollUsingJSE(ScrollSpecifiedPackageName);
	    }
    public void ViewSpecifiedPackage()
    {
    	ViewSpecifiedPackage.click();
    }
    public void ScrollTillLogoutLink(WebDriverUtility wdu,WebDriver driver)
    {
    	wdu.initializeJSE(driver);
    	wdu.scrollUsingJSE(UserLogoutLink);
    } 
    public void UserLogoutAction()
    {
    	UserLogoutLink.click();
    }
    public void writeUsLink()
    {
    	writeUsLink.click();
    }
    public void createIssue(WebDriverUtility wdu,  WebDriver driver,long timeInSeconds,String issueVisibletext,String issuedescription,int randomNumber)
	{

		wdu.initializeDropDown(issueDropdown);
		wdu.waitTillElementIsVisible(driver, timeInSeconds, issueDropdown);
		issueDropdown.click();
		wdu.selectOptionFromDropDownVisibletext(issueVisibletext);
		descriptionTextAreaField.sendKeys(issuedescription+randomNumber);
		submitButton.click();
	}
    public void clickOnIssueTickets(WebDriverUtility wdu, WebDriver driver,long timeInSeconds)
	{
		wdu.waitTillElementIsVisible(driver, timeInSeconds, issueTicketsButton);
		issueTicketsButton.click();
	}
    public void clickOnTourPackagesTab()
    {
    	clickOnTourPackagesTab.click();
    }
}
