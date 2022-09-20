package org.TMS.POMRepository;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssueTicketsPage {
	
	private WebDriver driver;

	//Declaration
	@FindBy(xpath = "(//table/descendant::td/ancestor::tr)[last()]") private WebElement lastEntry;
	//Initialization
	public IssueTicketsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Business Library
	public void scrolllastUpdatedemark(WebDriverUtility wdu)
	{
		wdu.scrollUsingJSE(lastEntry);
	}
	

}
