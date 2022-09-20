package org.TMS.POMRepository;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {
	
	@FindBy(xpath = "//i[@aria-hidden='true' and@class='fa fa-list-ul']")private WebElement Tourpackagebutton;
	@FindBy(xpath = "//a[.='Create']")private WebElement Creatbutton;
	@FindBy(xpath = "//p[.='Welcome']")private WebElement WelcomeDropdown;
	@FindBy(xpath = "//a[.=' Logout']")private WebElement LogoutLink;
    @FindBy(xpath = "//span[.='Manage Booking']") private WebElement ManageBookingTab;
    @FindBy(xpath = "//a[@class='sidebar-icon']") private WebElement CloseSidebarTab;
    @FindBy(xpath = "//h3[.='User']/following-sibling::h4") private WebElement userCount;
    @FindBy(xpath = "//span[.='Manage Issues']") private WebElement manageIssueButton;
    @FindBy(xpath = "(//a[.='View '])[last()]") private WebElement lastViewButton;
    @FindBy(xpath = "//h3[.='Toatal packages']/following-sibling::h4") private WebElement packageCount;
	public AdminDashBoardPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this); 
	}

	public void Tourpackagebutton() {
		Tourpackagebutton.click();
	}

	public void Creatbutton() {
		Creatbutton.click();
	}

	public void LogoutLink() {
		WelcomeDropdown.click();
		LogoutLink.click();
	}
	public void ManageBookingTab()
	{
		ManageBookingTab.click();
	}
    public void CloseSidebarTab()
    {
    	CloseSidebarTab.click();
    }
    public void scrollWelcome(WebDriver driver, WebDriverUtility wdu)
    {
    	wdu.initializeJSE(driver);
    	wdu.scrollUsingJSE(WelcomeDropdown);
    }
    public String userNumber()
	{
		return userCount.getText();	
	}
    public String packageCount()
    {
    	return packageCount.getText();
    } 
    public void manageIssueAction(WebDriverUtility wdu,WebDriver driver)
	{
		manageIssueButton.click();
		wdu.initializeJSE(driver);
		wdu.scrollUsingJSE(lastViewButton);
		lastViewButton.click();

	}
}
