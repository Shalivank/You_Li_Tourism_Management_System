package org.tsetNG.TMS.Scripts;

import org.TMS.POMRepository.AdminDashBoardPage;
import org.TMS.POMRepository.AdminRemarkUpdateWindow;
import org.TMS.POMRepository.UserHomePage;
import org.TMS.POMRepository.UserLoginPage;
import org.Youli.GenericUtilities.BaseClass;
import org.Youli.GenericUtilities.IConstantsPath;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RaiseIssueAsUserAndUpdateRemarkAsAdminTest extends BaseClass{
	@Test
	public void createBookingIssueAndUpdateRemark()
	{
		 String Username = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userusername");
		String password = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userpassword");
		String issueVisibletext = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Issue");
		String issuedescription = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "issuedesc");
		wp.UserLoginLink();
		UserLoginPage ulp=new UserLoginPage(driver);
		UserHomePage uhp=new UserHomePage(driver);
		ulp.UserLoginAction(Username, password );
		uhp.writeUsLink();
		uhp.createIssue(wdu, driver, longtime, issueVisibletext, issuedescription, random);
        uhp.UserLogoutAction();
        wp.AdminLoginLink();
        String validation=remark+random;
        alp.AdminLoginAction(Ausername, Apassword);
		AdminDashBoardPage adb=new AdminDashBoardPage(driver);
		adb.manageIssueAction(wdu,driver);
		wdu.switchToWindow(driver, "updateissue");
	    AdminRemarkUpdateWindow aruw=new AdminRemarkUpdateWindow(driver);
		String updateRemark = aruw.updateRemark(remark, random);
     	wdu.closeTheTab(driver);
		wdu.switchToWindow(driver, "manage");
		adb.scrollWelcome(driver, wdu);
		adb.LogoutLink();
		alp.BackHomeLink();
		wp.UserLoginLink();
		ulp.UserLoginAction(Username, password);
		uhp.clickOnIssueTickets(wdu, driver, longtime);
     	
		WebElement dynamicelement = wp.convertStringToWebelement(validation, driver);
		wdu.scrollUsingJSE(dynamicelement);
		String textfromDynamicElement = wp.getTextfromDynamicElement(validation, driver);
		uhp.UserLogoutAction();
		try {
			wdu.performValidationUsingAssert(updateRemark, textfromDynamicElement);
			System.out.println("test case is passed updated remaek");
			
		}
		catch (Exception e) {
			System.out.println("test case is failed not updated remark");
		}
		wdu.closeTheBrowser(driver);

	}
}
