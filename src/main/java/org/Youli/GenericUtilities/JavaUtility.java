package org.Youli.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this method is used to get the randomcount
	 * @param range
	 * @return
	 */
	public int getRandomNumber(int range) {
		Random random = new Random();
		int number = random.nextInt(range);
		return number;

	}
   /**
    * this method is used to convert to string to ant data type
    * @param data
    * @param strategy
    * @return
    */
	public Object convertStringIntoAnyDatatype(String data, DataType strategy) {
		Object obj = null;
		if (strategy.toString().equalsIgnoreCase("int")) {
			obj = Integer.parseInt(data);
		} else if (strategy.toString().equalsIgnoreCase("long")) {
			obj = Long.parseLong(data);
		} else {
			obj = (long) Double.parseDouble(data);
		}
		return obj;
	}
	 
	/**
	 * this method is used covert the date in to "dd-MM-yyyy-hh-mm-sss" this format
	 * @return
	 */
	public String currentTime()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy-hh-mm-sss");
		String actualDate = sdf.format(date);
		return actualDate;
	}
}