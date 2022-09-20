package org.Youli.GenericUtilities;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.cj.jdbc.Driver;

	/**
	 * this class is used for the action of all database activities
	 * @author SHALIVAN KHANDRE
	 *
	 */
	public class DataBaseUtility {
		private Connection connection;
		/**
		 * This method is used to fetch data from the DataBase
		 * @param query
		 * @param columnName
		 * @return
		 */
		public String getDataFromDataBase(String query,String columnName)
		{

			Statement Statement = null;
			try {
				Statement = connection.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ResultSet result = null;
			try {
				result = Statement.executeQuery(query);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			String fetchDBData=null;
			try {
				while(result.next())
				{
					try {
						fetchDBData = result.getString(columnName);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return fetchDBData;
		}
	/**
	 * This method is used to Open The DataBase Connection
	 * @param dbURL
	 * @param dbUserName
	 * @param dbPassword
	 */
		public void openDBConnection(String dbURL,String dbUserName,String dbPassword)
		{
			Driver dbdriver = null;
			try {
				dbdriver = new Driver();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				DriverManager.registerDriver(dbdriver);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(dbURL,dbUserName,dbPassword);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/**
		 * This method is used to Close the DataBase Connection
		 */
		public void closeDBConection()
		{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
}
