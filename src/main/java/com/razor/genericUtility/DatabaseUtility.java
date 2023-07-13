package com.razor.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * this class contains all common action related to database
 * @author Vishwanath-Naik
 *
 */
public class DatabaseUtility {
	
	Connection connection;
	Statement statement;
	/**
	 * this method is used to open the database connection and initialize the connection, statement
	 * @param dbUrl
	 * @param dbUsername
	 * @param dbPassword
	 * @throws SQLException
	 */
	public DatabaseUtility(String dbUrl, String dbUsername, String dbPassword) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		statement = connection.createStatement();
	}
	/**
	 * this method is used to fetch the data from database to do the DQL actions on database
	 * @param querry
	 * @param columName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> getDataFromDataBase(String querry, String columName) throws SQLException {
		ArrayList<String> list=new ArrayList<>();
		ResultSet result = statement.executeQuery(querry);
		while(result.next())
		{
			list.add(result.getString(columName));
		}
		return list;
	}
	/**
	 * this method is used to verify data whether it is present in the database or not
	 * @param querry
	 * @param columName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean validateDataInDataBase(String querry,String columName,String expectedData) throws SQLException {
		ArrayList<String> list = getDataFromDataBase(querry, columName);
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	/**
	 * this method is used to store/modify/insert/delete the data in database/to do the DML and DDL actions on database
	 * @param querry
	 * @throws SQLException
	 */
	public void setDataInDataBase(String querry) throws SQLException {
		int result=statement.executeUpdate(querry);
		if(result>=1) {
			System.out.println("Data entered/modified successfully");
		}
	}
	/**
	 * this method is used to close the database connection
	 */
	public void closeDBConnection() {
		try {
			connection.close();
		} 
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("while closing the Database connection we get exception");
		}
	}
}
