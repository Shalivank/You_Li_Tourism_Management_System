package org.TMS.POMRepository;

import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PackageDetailsPage {
   @FindBy(xpath = "//input[@name='fromdate']") private WebElement FromDate;
   @FindBy(xpath = "//a[.='10']") private WebElement FromPickDate;
   @FindBy(xpath = "//input[@name='todate']") private WebElement ToDate;
   @FindBy(xpath = "//a[.='20']") private WebElement ToPickDate;
   @FindBy(name = "comment") private WebElement Comment;
   @FindBy(xpath = "//button[.='Book']") private WebElement BookButton;
     
   public PackageDetailsPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void FillPackageDetailsAction()
   {
	   FromDate.click();
	   FromPickDate.click();
	   ToDate.click();
	   ToPickDate.click();
   }
   public void ScrollTillComment(WebDriverUtility wdu, WebDriver driver)
   {
	   wdu.scrollUsingJSE(Comment);
   }
   public void PassTheCommentIntoTextField(String comment)
   {
	   Comment.sendKeys(comment);
   }
   public void BookButton()
   {
	   BookButton.click();
   }
   
}
