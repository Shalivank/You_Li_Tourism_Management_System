package org.tsetNG.TMS.Scripts;

import java.util.List;
import java.util.Map;

import org.TMS.POMRepository.AdminDashBoardPage;
import org.TMS.POMRepository.CreatPackagePage;
import org.Youli.GenericUtilities.BaseClass;
import org.Youli.GenericUtilities.DataType;
import org.Youli.GenericUtilities.IConstantsPath;
import org.testng.annotations.Test;

public class CreatePackageTest extends BaseClass {
	@Test
	public void createPackageTest()
	{
        wp.AdminLoginLink();
        alp.AdminLoginAction(Ausername, Apassword);
		AdminDashBoardPage adb=new AdminDashBoardPage(driver);
		CreatPackagePage cp=new CreatPackagePage(driver);
		String pacakgeNumber = adb.packageCount();
		 int PKGCountBeforeCreatingPKG = (int)ju.convertStringIntoAnyDatatype(pacakgeNumber, DataType.INT);
		 System.out.println(pacakgeNumber);
		 adb.Tourpackagebutton();
		 adb.Creatbutton();
		 eu.openExcel(IConstantsPath.EXCEL_PATH, "package details");
		List<Map<String, String>> val = eu.getMultipleDataFromExcelUsingMap("package details");
		cp.CreatPackagedetails(val, random, wdu);
		cp.scrollTillCreateButton(driver, wdu);
		cp.CreatButton();
		cp.dashBoardTab();
	    String UpackageNumber = adb.packageCount();
	    int PKGCountAfterCreatePKG = (int)ju.convertStringIntoAnyDatatype(UpackageNumber, DataType.INT);
	    try
	    {
	    	wdu.performValidationUsingAssert(PKGCountAfterCreatePKG, PKGCountBeforeCreatingPKG+1);
	    	System.out.println("test case is passed -- package created succesfully");
	    }
	    catch(Exception e)
	    {
	    	System.out.println("test case is failed ");
	    }
	    
	    adb.LogoutLink();
	    
		
	}
}
