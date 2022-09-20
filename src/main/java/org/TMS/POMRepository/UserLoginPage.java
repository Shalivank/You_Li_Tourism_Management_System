package org.TMS.POMRepository;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
    WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Enter your Email']") private WebElement UsernameTextField;
    @FindBy(id  ="password" ) private WebElement PasswordTextField;
    @FindBy(name="signin") private WebElement SignInButton;
    
    
    public UserLoginPage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    public void UserLoginAction(String Username, String password)
    {
    	 UsernameTextField.sendKeys(Username);
    	 PasswordTextField.sendKeys(password);
    	 SignInButton.click();
    }
   
    
}
