package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DependentBean;
import bean.EmployeeBean;
import util.DbTransaction;

public class Dao {

	/*to validate the Employee Login*/
	public boolean checkEmpLogin(String id, String pass){
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs = null;
		String password=null;
		int status=0;
		con = DbTransaction.getConnection();
		try {
			st = con.prepareStatement("select password,status from Employee where id=?");
			st.setString(1, id);
			rs = st.executeQuery();
				if (rs.next()) {
					password=rs.getString("password");
					status=rs.getInt("status");
				}
				
				if(password!=null)
				{
					if(password.equals(pass) && status==1)
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
			st = con.prepareStatement("insert into Employee values(?,hi_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)");
			st.setInt(1,e.getEmp_id());
			st.setString(2, e.getEmp_name());
			st.setString(3, e.getEmp_dob());
			st.setString(4, e.getEmp_gen());
			st.setString(5,e.getEmp_email());
			st.setString(6, e.getEmp_alt_email());
			st.setString(7, e.getEmp_ph_no());
			st.setString(8,e.getEmp_mob_no());
			st.setString(9, e.getEmp_policy_start_date());
			st.setInt(10, e.getEmp_policy_period());
			st.setDouble(11,e.getEmp_tot_sum_ins());
			st.setDouble(12, e.getEmp_prem_amt());
			st.setString(13,e.getEmp_acc_no());
			st.setString(14, e.getEmp_bnk_name());
			st.setString(15, e.getEmp_bnk_ifsc());
			st.setString(16, e.getEmp_password());
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
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		EmployeeBean emp=null;
		con = DbTransaction.getConnection();
		try{
			st=con.prepareStatement("select * from Employee where id=?");
			st.setString(1, id);
			rs=st.executeQuery();
			
			while(rs.next()){
				emp=new EmployeeBean();
				emp.setEmp_id(Integer.parseInt(id));
				emp.setEmp_hi_id(Integer.parseInt(rs.getString("hi_id")));
				emp.setEmp_name(rs.getString("name"));
				emp.setEmp_dob(rs.getString("dob"));
				emp.setEmp_gen(rs.getString("gen"));
				emp.setEmp_email(rs.getString("email"));
				emp.setEmp_alt_email(rs.getString("alt_mail"));
				emp.setEmp_ph_no(rs.getString("ph_no"));
				emp.setEmp_mob_no(rs.getString("mob_no"));
				emp.setEmp_policy_start_date(rs.getString("policy_start_date"));
				emp.setEmp_policy_period(rs.getInt("policy_period"));
				emp.setEmp_tot_sum_ins(rs.getDouble("tot_sum_ins"));
				emp.setEmp_prem_amt(rs.getDouble("prem_amt"));
				emp.setEmp_acc_no(rs.getString("prem_amt"));
				emp.setEmp_bnk_name(rs.getString("bnk_name"));
				emp.setEmp_bnk_ifsc(rs.getString("ifsc"));
				emp.setEmp_password(rs.getString("password"));
				emp.setEmp_status(rs.getInt("status"));
			}
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return emp;
	}
	
	public boolean updateEmployee(EmployeeBean e){
		Connection con = null;
		PreparedStatement st=null;
		con = DbTransaction.getConnection();
		try {
			st = con.prepareStatement("Update Employee Set name=?, dob=?, gen=?, email=?, alt_mail=?, ph_no=?, mob_no=?, policy_start_date=?, policy_period=?, tot_sum_ins=?,prem_amt=?,acc_no=?, bnk_name=?, ifsc=?, password=? where id=? ");
			st.setString(1, e.getEmp_name());
			st.setString(2, e.getEmp_dob());
			st.setString(3, e.getEmp_gen());
			st.setString(4,e.getEmp_email());
			st.setString(5, e.getEmp_alt_email());
			st.setString(6, e.getEmp_ph_no());
			st.setString(7,e.getEmp_mob_no());
			st.setString(8, e.getEmp_policy_start_date());
			st.setInt(9,e.getEmp_policy_period());
			st.setDouble(10,e.getEmp_tot_sum_ins());
			st.setDouble(11, e.getEmp_prem_amt());
			st.setString(12,e.getEmp_acc_no());
			st.setString(13, e.getEmp_bnk_name());
			st.setString(14, e.getEmp_bnk_ifsc());
			st.setString(15, e.getEmp_password());
			st.setInt(16, e.getEmp_id());
			int flag=st.executeUpdate();
			if(flag==1)
			{	System.out.println("Updated Successfully, 1");
				return true;
			}
			System.out.println("could not Update, not 1");
			return false;
		
		} catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;
		
		
	}
	
	public boolean registerDependent(DependentBean d){
		Connection con=null;
		PreparedStatement st=null;
		con=DbTransaction.getConnection();
		int a=0;
		try {
			st=con.prepareStatement("insert into dependents values(?,hi_id.nextval,?,?,?,?,?,?,?,?)");
			st.setInt(1,d.getDep_id());
			st.setString(2,d.getDep_name());
			st.setString(3, d.getDep_relation());
			st.setString(4,d.getDep_dob());
			st.setString(5, d.getDep_gender());
			st.setString(6,d.getDep_policy_start_date());
			st.setInt(7,d.getDep_policy_period());
			st.setDouble(8,d.getDep_tot_sum_ins());
			st.setDouble(9, d.getDep_prem_amt());
			a=st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==1){
			System.out.println("dependent inserted");
			return true;
		}
		System.out.println("dependent insertion failed");
		return false;
	}

	public ArrayList<DependentBean> getDependents(int id) {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		EmployeeBean emp=null;
		ArrayList<DependentBean> dblist=null;
		con = DbTransaction.getConnection();
		try{
			st=con.prepareStatement("select * from Dependents where id=?");
			st.setInt(1, id);
			rs=st.executeQuery();
			dblist=new ArrayList<DependentBean>();
			while(rs.next()){
				DependentBean db=new DependentBean();
				db.setDep_id(rs.getInt("emp_id"));
				db.setDep_hi_id(rs.getInt("hi_id"));
				db.setDep_name(rs.getString("name"));
				db.setDep_relation(rs.getString("relation"));
				db.setDep_gender(rs.getString("gen"));
				db.setDep_policy_start_date(rs.getString("policy_start_date"));
				db.setDep_policy_period(rs.getInt("policy_period"));
				db.setDep_tot_sum_ins(rs.getDouble("tot_sum_ins"));
				db.setDep_prem_amt(rs.getDouble("prem_amt"));
				
				dblist.add(db);
				return dblist;
			}
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return dblist;
	}

	public boolean deleteEmployee(String id) {
		Connection con = null;
		PreparedStatement st=null;
		int a;
		con = DbTransaction.getConnection();
		try{
			st=con.prepareStatement("delete from employee where id=?");
			st.setString(1, id);
			a=st.executeUpdate();
			if(a>0)
				return true;
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;

	}
}