package org.Youli.GenericUtilities;

import org.TMS.POMRepository.AdminLoginPage;
import org.TMS.POMRepository.WelcomePage;
import org.lara.project.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	protected WebDriverUtility wdu;
	protected ExcelUtility eu;
	protected FileUtility fu;
	protected JavaUtility ju;
	protected String browser;
	protected String url;
	protected String laraurl;
	protected String Ausername;
	protected String Apassword;
	protected long longtime;
	protected AdminLoginPage alp;
	protected WelcomePage wp;
	protected LoginPage llp;     //
	protected int random;
	protected String remark;
    public static WebDriver sdriver;
    public static JavaUtility sju;
	@BeforeClass
	public void classSetup() {
		wdu = new WebDriverUtility();
		fu = new FileUtility();
		eu = new ExcelUtility();
		ju = new JavaUtility();
		sju=ju;
		random = ju.getRandomNumber(1000);
		browser = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "browser");
		url = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "url");
		laraurl=fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "laraurl");
		Ausername = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "Adminusername");
		Apassword = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "adminpassword");
		String time = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "TimeUnit");
		 remark = fu.getDataFromPropertyfile(IConstantsPath.PROPERTY_FILE_PATH, "remark");
		longtime = (long)ju.convertStringIntoAnyDatatype(time, DataType.LONG);
		driver=wdu.commonOperation(browser, url, longtime);
		 sdriver = driver;
		wdu.initializeJSE(driver);

	}

	@BeforeMethod	public void methodSetup() {
//
    	wp = new WelcomePage(driver);
//	    llp=new LoginPage(driver);
    	alp = new AdminLoginPage(driver);
//		
//
	}

	@AfterClass
	public void afterClassSetup() {
		wdu.closeTheBrowser(driver);
	}
}
