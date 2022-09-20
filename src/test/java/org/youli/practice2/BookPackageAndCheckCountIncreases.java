package org.youli.practice2;

import org.TMS.POMRepository.AdminDashBoardPage;
import org.TMS.POMRepository.AdminLoginPage;
import org.TMS.POMRepository.ManageBookingPage;
import org.TMS.POMRepository.PackageDetailsPage;
import org.TMS.POMRepository.UserHomePage;
import org.TMS.POMRepository.UserLoginPage;
import org.TMS.POMRepository.WelcomePage;
import org.Youli.GenericUtilities.ExcelUtility;
import org.Youli.GenericUtilities.FileUtility;
import org.Youli.GenericUtilities.IConstantsPath;
import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;

public class BookPackageAndCheckCountIncreases {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wdu = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		String browser = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "browser");
		String url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "url");
		String Ausername = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Adminusername");
		String Apassword = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "adminpassword");
		String Username = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userusername");
		String password = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Userpassword");
		String comment = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "comment");
		WebDriver driver = wdu.commonOperation(browser, url, 10);
		WelcomePage wp = new WelcomePage(driver);
		AdminLoginPage alp = new AdminLoginPage(driver);
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
		System.out.println("Before Booking The count"+"+---->"+str[1]);
		adb.scrollWelcome(driver, wdu);
		adb.LogoutLink();
		alp.BackHomeLink();
		wp.UserLoginLink();
		ulp.UserLoginAction(Username, password);
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
		if (AfterBookCount > BeforeBookCount) {
			System.out.println("tc is pass");
		} else {
			System.out.println("tc is fail");
		}
		wdu.closeTheBrowser(driver);

	}

}
