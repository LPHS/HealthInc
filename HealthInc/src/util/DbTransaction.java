package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTransaction 
{
	private static Connection connection=null;
	private static String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static String user="system";
	private static String password="suraj";

	public static Connection getConnection() 
	{
		try 
		{
			closeConnection(connection);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url,user,password);
		} 		
		catch (SQLException e) 
		{
		e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
		e.printStackTrace();
		}
		return connection;
	
	}
    public static void closeConnection(Connection connection)
    {
		 
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}	
	}
}
