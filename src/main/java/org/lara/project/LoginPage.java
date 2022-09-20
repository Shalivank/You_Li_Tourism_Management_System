package org.lara.project;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
        @FindBy(id= "email") private WebElement emailTextfield;
        @FindBy(id="password") private WebElement passwordTextfield;
        @FindBy(id="loginBtn") private WebElement loginButtton;
        @FindBy(xpath = "//a[.='Login']") private WebElement loginLink;
        
        public LoginPage(WebDriver driver)
        {
        	PageFactory.initElements(driver, this);
        }
        public void loginLink()
        {
        	loginLink.click();
        }
        public void loginAction(List<Map<String, String>> map)
        {
        	
        	emailTextfield.sendKeys(map.get(0).get("email"));
        	passwordTextfield.sendKeys(map.get(0).get("password"));
        	loginButtton.click();
        }
}
