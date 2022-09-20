package org.tsetNG.TMS.Scripts;

import java.util.List;
import java.util.Map;

import org.TMS.POMRepository.AdminDashBoardPage;
import org.Youli.GenericUtilities.BaseClass;
import org.Youli.GenericUtilities.DataType;
import org.Youli.GenericUtilities.IConstantsPath;
import org.testng.annotations.Test;

public class CreateUserAndCheckCountTest extends BaseClass {

	@Test
	public void creatUserCheckCount() {
		wp.AdminLoginLink();
		alp.AdminLoginAction(Ausername, Apassword);
		AdminDashBoardPage adb = new AdminDashBoardPage(driver);
		String userNumber = adb.userNumber();
		int ucountBeforCreatingUser = (int) ju.convertStringIntoAnyDatatype(userNumber, DataType.INT);
		System.out.println(ucountBeforCreatingUser);
		adb.LogoutLink();
		alp.BackHomeLink();
		wp.signupLink();
		eu.openExcel(IConstantsPath.EXCEL_PATH, "UserData");
		List<Map<String, String>> UserDetails = eu.getMultipleDataFromExcelUsingMap("UserData");
//		System.out.println(UserDetails);
		wp.createUser(UserDetails, random, wdu);
		wp.AdminLoginLink();
		alp.AdminLoginAction(Ausername, Apassword);
		String updateduserNumber = adb.userNumber();
		int ucountAfterCreatingUser = (int) ju.convertStringIntoAnyDatatype(updateduserNumber, DataType.INT);
		System.out.println("Count of users before creating a new user " + userNumber);
		System.out.println("Count of users after creating a new user " + updateduserNumber);
		try {
			
			wdu.performValidationUsingAssert(ucountBeforCreatingUser + 1, ucountAfterCreatingUser);
			System.out.println("Test Case Pass");
		} catch (Exception e) {
			System.out.println("Test case fail");
		}
		adb.LogoutLink();
	}

}
