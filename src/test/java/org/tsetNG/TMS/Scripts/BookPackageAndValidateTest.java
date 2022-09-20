package org.tsetNG.TMS.Scripts;

import org.TMS.POMRepository.AdminDashBoardPage;
import org.TMS.POMRepository.ManageBookingPage;
import org.TMS.POMRepository.PackageDetailsPage;
import org.TMS.POMRepository.UserHomePage;
import org.TMS.POMRepository.UserLoginPage;
import org.Youli.GenericUtilities.BaseClass;
import org.Youli.GenericUtilities.IConstantsPath;
import org.testng.annotations.Test;

public class BookPackageAndValidateTest extends BaseClass{
    @Test
    public void bookPackageCheckCountIncreases()
    {
    	String Username = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userusername");
		String Password = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userpassword");
		String comment = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "comment");
		AdminDashBoardPage adb = new AdminDashBoardPage(driver);
		ManageBookingPage mbp = new ManageBookingPage(driver);
		UserLoginPage ulp = new UserLoginPage(driver);
		UserHomePage uhp = new UserHomePage(driver);
		PackageDetailsPage pdp = new PackageDetailsPage(driver);
		wp.AdminLoginLink();
		alp.AdminLoginAction(Ausername, Apassword);
		adb.ManageBookingTab();
		adb.CloseSidebarTab();
		mbp.scrollBookingId(wdu);
		String value = mbp.fetchLastBookingId();
		String fString = value.toString();
		String[] str = fString.split("-");
		System.out.println("Before Booking The count"+"---->"+str[1]);
		adb.scrollWelcome(driver, wdu);
		adb.LogoutLink();
		alp.BackHomeLink();
		wp.UserLoginLink();
		ulp.UserLoginAction(Username, Password);
		uhp.clickOnTourPackagesTab();
		uhp.ScrollSpecifiedPackageName(driver,wdu);
		uhp.ViewSpecifiedPackage();
		pdp.FillPackageDetailsAction();
		pdp.ScrollTillComment(wdu, driver);
		pdp.PassTheCommentIntoTextField(comment);
		pdp.BookButton();
		uhp.ScrollTillLogoutLink(wdu,driver);
		uhp.UserLogoutAction();
		wp.AdminLoginLink();
		alp.AdminLoginAction(Ausername, Apassword);
		adb.ManageBookingTab();
		adb.CloseSidebarTab();
		mbp.scrollBookingId(wdu);
		String value1 = mbp.fetchLastBookingId();
		String String = value1.toString();
		String[] str1 = String.split("-");
		System.out.println("After Booking The count"+"---->"+str1[1]);
		String xyz = str[1];
		String abc = str1[1];
		int BeforeBookCount = Integer.parseInt(xyz);
		int AfterBookCount = Integer.parseInt(abc);
		try {
		wdu.performValidationUsingAssert(AfterBookCount, BeforeBookCount+1);
		System.out.println("test case pass");
		}
		catch(Exception e)
		{
			System.out.println("test case is fail");
		}
		adb.scrollWelcome(driver, wdu);
		adb.LogoutLink();

    }
	
}
