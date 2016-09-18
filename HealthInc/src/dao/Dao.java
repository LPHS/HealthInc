package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.EmployeeBean;

import util.DbTransaction;

public class Dao {

	/*to validate the Employee Login*/
	public boolean checkEmpLogin(String id, String pass){
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs = null;
		String password=null;
		con = DbTransaction.getConnection();
		try {
			st = con.prepareStatement("select password from Employee where id=?");
			st.setString(1, id);
			rs = st.executeQuery();
				if (rs.next()) {
					password=rs.getString("password");
					
				}
				
				if(password!=null)
				{
					if(password.equals(pass))
						return true;
				
				}
				return false;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;
	}
	
	/*to validate the Admin Login*/
	public boolean checkAdminLogin(String id, String pass){
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs = null;
		String password=null;
		con = DbTransaction.getConnection();
		try {
			st = con.prepareStatement("select password from Admin where id=?");
			st.setString(1, id);
			rs = st.executeQuery();
				if (rs.next()) {
					password=rs.getString("password");
					
				}
				
				if(password!=null)
				{	
					if(password.equals(pass))
					{	System.out.println(pass+ " "+password);
						return true;
					}
				}
				return false;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;
		
		
	}
	
	/*to add the Employee details to the table and check whether the employee id already exists*/
	public boolean registerEmployee(EmployeeBean e){
		
	}
	
	/*fetch the row according to emp id*/
	public EmployeeBean getEmpDetail(String id){
		
	}
	
}
