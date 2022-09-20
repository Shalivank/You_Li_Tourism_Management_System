package org.TMS.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
    @FindBy(className="name")private WebElement UserNameTextField;
    @FindBy(className="password") private WebElement PasswordTextField;
    @FindBy(name="login") private WebElement loginButton;
    @FindBy(xpath = "//a[.='Back to home']") private WebElement BackHomeLink;
    
    public AdminLoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    public void AdminLoginAction(String Ausername,String Apassword)
    
    {
    	UserNameTextField.sendKeys(Ausername);
    	PasswordTextField.sendKeys(Apassword);
    	loginButton.click();
    }
     public void BackHomeLink()
     {
    	 BackHomeLink.click();
     }
   
    
}
