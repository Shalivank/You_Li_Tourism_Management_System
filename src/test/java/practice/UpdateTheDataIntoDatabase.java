package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class UpdateTheDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into sdet40 values(4433, 'sharath', 98789988, 'vijaynagar')");
           ResultSet result = statement.executeQuery("select * from sdet40;");
           while(result.next())
           {
        	   System.out.println(result.getString("emp_name"));
           }
	}

}
