package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Connection con = null;
		PreparedStatement st=null;
		con = DbTransaction.getConnection();
		try {
			st = con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1,e.getEmp_id());
			st.setInt(2, e.getEmp_hi_id());
			st.setString(3, e.getEmp_name());
			st.setString(4, e.getEmp_dob());
			st.setString(5, e.getEmp_gen());
			st.setString(6,e.getEmp_email());
			st.setString(7, e.getEmp_alt_email());
			st.setString(8, e.getEmp_ph_no());
			st.setString(9,e.getEmp_mob_no());
			st.setString(10, e.getEmp_policy_start_date());
			st.setInt(11, e.getEmp_policy_period());
			st.setDouble(12, e.getEmp_prem_amt());
			st.setDouble(13,e.getEmp_prem_amt());
			st.setString(14,e.getEmp_acc_no());
			st.setString(15, e.getEmp_bnk_name());
			st.setString(16, e.getEmp_bnk_ifsc());
			st.setString(17, e.getEmp_password());
			st.setInt(18, 0);
			int flag=st.executeUpdate();
			if(flag==1)
			{	System.out.println("Inserted Successfully, 1");
				return true;
			}
			System.out.println("could'nt be inserted, not 1");
			return false;
		
		} catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;
		
		
	}
	
	/*fetch the row according to emp id*/
	public EmployeeBean getEmpDetail(String id){
		
		
	}
	
}
