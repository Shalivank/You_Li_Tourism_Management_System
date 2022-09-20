package org.youli.practice2;

import java.util.List;
import java.util.Map;

import org.Youli.GenericUtilities.BaseClass;
import org.Youli.GenericUtilities.IConstantsPath;
import org.testng.annotations.Test;

public class LaraTest extends BaseClass {
	
	@Test
	
	public void login()
	{
		eu.openExcel(IConstantsPath.EXCEL_PATH,"package details");
		List<Map<String, String>> ele = eu.getMultipleDataFromExcelUsingMap("package details");
		llp.loginLink();
		llp.loginAction(ele);
	}

}
