package org.TMS.POMRepository;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageBookingPage {
	WebDriver driver;
    @FindBy(xpath = "//table/tbody/tr[last()]/td[@data-th='Booikn id']") 
    private WebElement BookingId;
    
    public  ManageBookingPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    
    public void scrollBookingId(WebDriverUtility wdu)
    {
    	wdu.initializeJSE(driver);
    	wdu.scrollUsingJSE(BookingId);
    }
    
    public String fetchLastBookingId()
    {
    	return BookingId.getText();
    }
}
