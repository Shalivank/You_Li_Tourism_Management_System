package org.TMS.POMRepository;

import java.util.List;
import java.util.Map;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
  @FindBy(xpath="//a[.='Admin Login']") private WebElement AdminLoginLink;
  @FindBy(xpath="//a[.='/ Sign In']") private WebElement UserSigninLink;
  @FindBy(xpath = "//a[.='Sign Up']") private WebElement signupLink;
  @FindBy(xpath = "//input[@name='fname']") private WebElement newUsernameTextfield;
  @FindBy(xpath = "//input[@name='mobilenumber']") private WebElement mobileNumTextfield;
  @FindBy(xpath = "//h3[.='Create your account ']/following-sibling::input[@id='email']") private WebElement emailTextField;
  @FindBy(xpath = "//input[@placeholder='Password']") private WebElement userPassword;
  @FindBy(xpath = "//input[@id='submit']") private WebElement submitButton;
private String dynamicXpath="//tbody/tr/td[.='%s']";
    
  public WelcomePage(WebDriver driver)
  {
	
	  PageFactory.initElements(driver, this);
  }
  
  public void AdminLoginLink()
  {
	  AdminLoginLink.click();
  }
  public void UserLoginLink()
  {
	  UserSigninLink.click();
  }
  public void signupLink()
  {
	  signupLink.click();
  }
  public void createUser(List<Map<String, String>> map,int random,WebDriverUtility wdu)
	{
		newUsernameTextfield.sendKeys(map.get(0).get("FullName")+random);
		mobileNumTextfield.sendKeys(map.get(0).get("MobileNo")+random);
		emailTextField.sendKeys(map.get(0).get("Email")+random);
		userPassword.sendKeys(map.get(0).get("Password")+random);
		submitButton.click();

	}
  public WebElement convertStringToWebelement(String replaceData,WebDriver driver)
	{
		String requiredPath = String.format(dynamicXpath, replaceData);
		WebElement dynamicElement = driver.findElement(By.xpath(requiredPath));
		return dynamicElement;
	}
	/**
	 * This method is used to fetch Text from a Dynamic Element
	 * @param dynamicXpath
	 * @param replaceData
	 * @return
	 */
	public String getTextfromDynamicElement(String replaceData,WebDriver driver)
	{
		String requiredPath = String.format(dynamicXpath,replaceData);
		String dynamicElement = driver.findElement(By.xpath(requiredPath)).getText();	
		return dynamicElement;
	}
}
