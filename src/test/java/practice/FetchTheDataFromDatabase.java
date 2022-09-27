package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class FetchTheDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from sdet40;");
		while(result.next())
		{
			System.out.println(result.getString("emp_name"));
		}
	}
}

