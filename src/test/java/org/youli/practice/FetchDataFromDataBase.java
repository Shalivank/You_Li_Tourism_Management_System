package org.youli.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
public class FetchDataFromDataBase {
   
	public static void main(String[] args) throws SQLException {
	  Driver dbdriver=new Driver();
	  DriverManager.registerDriver(dbdriver);
	  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root","root");
	       Statement statement = connection.createStatement();
	//       statement.executeUpdate("insert into sdet40 values(4430,'abhi',98798898,'bijapur');");
	       ResultSet result = statement.executeQuery("select * from sdet40;");
	      
	      while(result.next())//while loop accept always boolean type of data
	     {
	    	   System.out.println(result.getString("emp_id"));
	      }
	  
	}

}
