package org.TMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnquiryPage {
   @FindBy(id="fname") private WebElement fullNameTextField;
   @FindBy(id="email") private WebElement emailTextField;
   @FindBy(id="mobileno") private WebElement mobileNumberTextField;
   @FindBy(id="subject") private WebElement subjectTextField;
   @FindBy(id="description") private WebElement descriptionTextAreaField;
   @FindBy(id="subnit1") private WebElement submitButton; 
   
   public EnquiryPage (WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
   
   public void enquiryDetails()
   {
	   fullNameTextField.sendKeys(null);
	   emailTextField.sendKeys(null);
	   mobileNumberTextField.sendKeys(null);
	   subjectTextField.sendKeys(null);
	   
   }
}
