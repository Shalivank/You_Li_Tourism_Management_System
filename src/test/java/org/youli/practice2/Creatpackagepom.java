package org.youli.practice2;

import org.TMS.POMRepository.AdminDashBoardPage;
import org.TMS.POMRepository.AdminLoginPage;
import org.TMS.POMRepository.CreatPackagePage;
import org.TMS.POMRepository.WelcomePage;
import org.Youli.GenericUtilities.ExcelUtility;
import org.Youli.GenericUtilities.FileUtility;
import org.Youli.GenericUtilities.IConstantsPath;
import org.Youli.GenericUtilities.WebDriverUtility;
import org.openqa.selenium.WebDriver;

public class Creatpackagepom {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wdu=new WebDriverUtility();
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		String browser = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "browser");
		String url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "url");
		String Ausername = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Adminusername");
		String Apassword = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "adminpassword");
		String packagename = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 0, 1);
		String packagetype = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 1, 1);
		String packagelocation = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 2, 1);
		String packageprice = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 3, 1);
		String packagefeatures = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 4, 1);
		String packagedetails = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 5, 1);
		String imagpath = eu.getValuesFromExcel(IConstantsPath.EXCEL_PATH, "package details", 6, 1);
		WebDriver driver = wdu.commonOperation(browser, url, 10);
		WelcomePage wp=new WelcomePage(driver);
		AdminLoginPage alp=new AdminLoginPage(driver);
		AdminDashBoardPage adb=new AdminDashBoardPage(driver);
		CreatPackagePage cp=new CreatPackagePage(driver);
		wp.AdminLoginLink();
		alp.AdminLoginAction(Ausername, Apassword);
		adb.Tourpackagebutton();
		adb.Creatbutton();
		//cp.CreatPackagedetails(packagename, packagetype, packagelocation, packageprice, packagefeatures, packagedetails, imagpath);
		cp.scrollTillCreateButton(driver, wdu);
		//cp.CreatPackagedetails(packagename, packagetype, packagelocation, packageprice, packagefeatures, packagedetails, imagpath);
		cp.CreatButton();
		 String ele = cp.fetchText();
		 System.out.println(ele);
		wdu.closeTheBrowser(driver);
		
		
				

	}

}
