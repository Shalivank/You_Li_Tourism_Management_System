package org.TMS.POMRepository;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatPackagePage {

	@FindBy(name = "packagename")
	private WebElement PackageNameTextfield;
	@FindBy(name = "packagetype")
	private WebElement PackageTypeTextfield;
	@FindBy(name = "packagelocation")
	private WebElement PackageLocationTextfield;
	@FindBy(name = "packageprice")
	private WebElement PackagePriceTextfield;
	@FindBy(name = "packagefeatures")
	private WebElement PackageFeaturesTextfield;
	@FindBy(name = "packagedetails")
	private WebElement PackageDetailsTextfield;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement ImageFIleBrowser;
	@FindBy(xpath = "//button[.='Create']")
	private WebElement CreatButton;
	@FindBy(xpath = "//button[.='Reset']")
	private WebElement ResetButton;
	@FindBy(xpath = "//div[@class='succWrap']")
	private WebElement SuccessText;
	@FindBy(xpath = "//span[.='Dashboard']") private WebElement dashBoardTab;

	public CreatPackagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void CreatPackagedetails(List<Map<String, String>> map,int random,WebDriverUtility wdu) {
		PackageNameTextfield.sendKeys(map.get(0).get("packagename")+random);
		PackageTypeTextfield.sendKeys(map.get(0).get("packagetype"));
		PackageLocationTextfield.sendKeys(map.get(0).get("packagelocation"));
		PackagePriceTextfield.sendKeys(map.get(0).get("packageprice")+random);
		PackageDetailsTextfield.sendKeys(map.get(0).get("packagefeatures"));
		PackageFeaturesTextfield.sendKeys(map.get(0).get("packagedetails"));
		ImageFIleBrowser.sendKeys(map.get(0).get("imagpath"));

	}

	public void CreatButton() {
		CreatButton.click();
	}

	public void ResetButton() {
		ResetButton.click();
	}

	public void scrollTillCreateButton(WebDriver driver, WebDriverUtility wdu) {
		wdu.initializeJSE(driver);
		wdu.scrollUsingJSE(CreatButton);
	}
	public String fetchText()
	{
		return SuccessText.getText();
		
	}
	public void dashBoardTab()
	{
		dashBoardTab.click();
	}
}
