package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ClaimBean;
import bean.DependentBean;
import bean.DomiciliaryBean;
import bean.EmployeeBean;
import bean.Hospital;
import bean.HospitalizationBean;
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
				emp.setEmp_hi_id(rs.getInt("hi_id"));
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
			st=con.prepareStatement("insert into dependents values(?,hi_id.nextval,?,?,?,?,?,?,?,?,0)");
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
			st=con.prepareStatement("select * from Dependents where emp_id=? and status=1");
			st.setInt(1, id);
			rs=st.executeQuery();
			dblist=new ArrayList<DependentBean>();
			while(rs.next()){
				DependentBean db=new DependentBean();
				db.setDep_id(rs.getInt("emp_id"));
				db.setDep_hi_id(rs.getInt("hi_id"));
				db.setDep_name(rs.getString("name"));
				db.setDep_relation(rs.getString("relation"));
				db.setDep_dob(rs.getString("DOB"));
				db.setDep_gender(rs.getString("gen"));
				db.setDep_policy_start_date(rs.getString("policy_start_date"));
				db.setDep_policy_period(rs.getInt("policy_period"));
				db.setDep_tot_sum_ins(rs.getDouble("tot_sum_ins"));
				db.setDep_prem_amt(rs.getDouble("prem_amt"));
				db.setStatus(rs.getInt("status"));
				dblist.add(db);
			}
			return dblist;
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return dblist;
	}

	public DependentBean getDependentDetails(int id) {
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		con = DbTransaction.getConnection();
		DependentBean db=null;
		try{
			st=con.prepareStatement("select * from Dependents where hi_id=?");
			st.setInt(1, id);
			rs=st.executeQuery();
			db=new DependentBean();
			while(rs.next()){
				db.setDep_hi_id(rs.getInt("hi_id"));
				db.setDep_id(rs.getInt("emp_id"));
				db.setDep_name(rs.getString("name"));
				db.setDep_relation(rs.getString("relation"));
				db.setDep_dob(rs.getString("dob"));
				db.setDep_gender(rs.getString("gen"));
				db.setDep_policy_start_date(rs.getString("policy_start_date"));
				db.setDep_policy_period(rs.getInt("policy_period"));
				db.setDep_tot_sum_ins(rs.getDouble("tot_sum_ins"));
				db.setDep_prem_amt(rs.getDouble("prem_amt"));
				db.setStatus(rs.getInt("status"));

			}
			return db;
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return db;
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

	public boolean updateDependentDetails(DependentBean d) {
		Connection con = null;
		PreparedStatement st=null;
		con = DbTransaction.getConnection();
		try {
			st = con.prepareStatement("Update dependents Set name=?, relation=?, dob=?, gen=?, policy_start_date=?, policy_period=?, tot_sum_ins=?,prem_amt=? where hi_id=?");
			st.setString(1, d.getDep_name());
			st.setString(2, d.getDep_relation());
			st.setString(3, d.getDep_dob());
			st.setString(4, d.getDep_gender());
			st.setString(5, d.getDep_policy_start_date());
			st.setInt(6, d.getDep_policy_period());
			st.setDouble(7, d.getDep_tot_sum_ins());
			st.setDouble(8, d.getDep_prem_amt());
			st.setInt(9,d.getDep_hi_id());

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

	public boolean deleteDependent(int id) {
		Connection con = null;
		PreparedStatement st=null;
		int a;
		con = DbTransaction.getConnection();
		try{
			st=con.prepareStatement("delete from dependents where hi_id=?");
			st.setInt(1, id);
			a=st.executeUpdate();
			if(a>0)
				return true;
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;
	}
	
	public boolean domClaim(DomiciliaryBean dom){
		Connection con=null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		try {
			st=con.prepareStatement("insert into domclaim values(claim_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,0,0)");
			st.setInt(1, dom.getEmpId());
			st.setString(2, dom.getBenefName());
			st.setInt(3, dom.getEmpHiId());
			st.setString(4, dom.getPhoneNumber());
			st.setString(5, dom.getAddress());
			st.setString(6, dom.getAltEmailId());
			st.setString(7, dom.getTrtStartDate());
			st.setString(8, dom.getTrtEndDate());
			st.setString(9, dom.getDateOfInjuiry());
			st.setString(10, dom.getNameOfDoctor());
			st.setString(11, dom.getDetailsOfInjuiry());
			st.setDouble(12, dom.getTotalClaimAmt());
			a=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		if(a==1){
			System.out.println("Domiciliary inserted");
			return true;
		}
		System.out.println("Domiciliary Failed");
		return false;
	}
	
	public boolean hosClaim(HospitalizationBean hos){
		Connection con=null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		try {
			st=con.prepareStatement("insert into hosclaim values(claim_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,0)");
			st.setInt(1, hos.getEmpId());
			st.setString(2,hos.getEmpName());
			st.setString(3, hos.getEmail());
			st.setString(4, hos.getMobNo());
			st.setString(5, hos.getCompanyName());
			st.setString(6, hos.getNameOfPatient());
			st.setString(7, hos.getGender());
			st.setString(8, hos.getRelationship());
			st.setInt(9, hos.getAge());
			st.setInt(10, hos.getHiid());
			st.setString(11, hos.getState());
			st.setString(12, hos.getCity());
			st.setString(13, hos.getHosName());
			st.setString(14, hos.getAddress());
			st.setString(15, hos.getDateOfAdmission());
			st.setString(16, hos.getDateOfDischarge());
			st.setString(17, hos.getNameOfDoctor());
			st.setString(18, hos.getDetailsOfInjury());
			st.setString(19, hos.getReasonOfInjury());
			st.setDouble(20, hos.getTotalClaimAmt());
			a=st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		if(a==1){
			System.out.println("Hospitalization Inserted");
			return true;
		}
		System.out.println("Hospitalization Failed");
		return false;
	}
	
	public ArrayList<ClaimBean> claimSearch(int hid){
		Connection con = null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		ResultSet rs=null;
		ClaimBean cb=null;
		ArrayList<ClaimBean> cbList=new ArrayList<ClaimBean>();
		try {		
			
			//first searching from domiciliary claim tables
			st=con.prepareStatement("select * from domclaim where empHiId=?");
			st.setInt(1, hid);
			rs=st.executeQuery();
			while(rs.next()){
				cb=new ClaimBean();
				cb.setClaimType("Domiciliary");
				cb.setPatientName(rs.getString("benefName"));
				cb.setMediAssistClaimNo(rs.getInt("domClmId"));
				cb.setRelation(getRelationDep(hid,con));
				cb.setClaimAmt(rs.getDouble("totalClaimAmt"));
				cb.setApprovedAmt(rs.getDouble("approvedAmt"));
				cb.setStatus(rs.getInt("status"));
				cbList.add(cb);
			}
			
			//searching from hospitalization claim tables
			st=con.prepareStatement("select * from hosclaim where HiId=?");
			st.setInt(1, hid);
			rs=st.executeQuery();
			while(rs.next()){
				cb=new ClaimBean();
				cb.setClaimType("Hospitalization");
				cb.setPatientName(rs.getString("nameOfPatient"));
				cb.setMediAssistClaimNo(rs.getInt("hosClmId"));
				cb.setRelation(rs.getString("relationship"));
				cb.setClaimAmt(rs.getDouble("totalClaimAmt"));
				cb.setApprovedAmt(rs.getDouble("approvedAmt"));
				cb.setStatus(rs.getInt("status"));
				cbList.add(cb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return cbList;
	}
	
	
	//to get relation of the dependent for domclaim table
	public String getRelationDep(int hid,Connection con){
		PreparedStatement st=null;
		int a=0;
		ResultSet rs=null;
		String relation=null;
		try {
			st=con.prepareStatement("select relation from dependents where hi_id=?");
			st.setInt(1, hid);
			rs=st.executeQuery();
			while(rs.next()){
				relation=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relation;
	}
	
	public boolean addHospital(Hospital h) {
		Connection con=null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		try {
			st=con.prepareStatement("insert into Hospital values(?,?,?,?,?,?,?,?)");
			st.setInt(1, h.getId());
			st.setString(2,h.getName());
			st.setString(3, h.getAddress());
			st.setString(4, h.getCity());
			st.setString(5, h.getState());
			st.setLong(6, h.getPin());
			st.setLong(7, h.getStd());
			st.setString(8, h.getPhone());
			a=st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==1){
			System.out.println("Hospital Created");
			return true;
		}
		System.out.println("Hospital Creation Failed");
		return false;
	}
	
	
	public boolean updateHospital(Hospital h)
	{
		Connection con = null;
		PreparedStatement st=null;
		con = DbTransaction.getConnection();
			try {
			st = con.prepareStatement("Update Hospital Set name=?, address=?, city=?, state=?, pin=?, std=?, phone=? where id=?");
			st.setString(1,h.getName());
			st.setString(2,h.getAddress());
			st.setString(3,h.getCity());
			st.setString(4,h.getState());
			st.setInt(5,h.getPin());
			st.setInt(6, h.getStd());
			st.setString(7,h.getPhone());
			st.setInt(8, h.getId());
			
			int flag=st.executeUpdate();
			System.out.println("flag=:"+flag);
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

	public Hospital getHospital(int hid) {
		Hospital h=null;
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		con = DbTransaction.getConnection();
		DependentBean db=null;
		try{
			st=con.prepareStatement("select * from Hospital where id=?");
			st.setInt(1, hid);
			rs=st.executeQuery();
			db=new DependentBean();
			while(rs.next()){
				h=new Hospital();
				h.setId(rs.getInt("id"));
				h.setName(rs.getString("name"));
				h.setAddress(rs.getString("address"));
				h.setCity(rs.getString("city"));
				h.setPhone(rs.getString("phone"));
				h.setPin(rs.getInt("pin"));
				h.setState(rs.getString("state"));
				h.setStd(rs.getInt("std"));
				}
			return h;
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return h;
		
	}

	public boolean deleteHospital(int hid) {
		Connection con = null;
		PreparedStatement st=null;
		con = DbTransaction.getConnection();
		
		try {
			st = con.prepareStatement("delete from Hospital where id=?");
			st.setInt(1,hid);
			
			int flag=st.executeUpdate();
			if(flag==1)
			{	System.out.println("Deleted Successfully, 1");
				return true;
			}
			System.out.println("could not Delete, not 1");
			return false;
		
		} catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return false;
	}
	
	public ArrayList<ClaimBean> returnApprovalClaims(){
		Connection con = null;
		PreparedStatement st=null;
		con=DbTransaction.getConnection();
		ResultSet rs=null;
		ClaimBean cb=null;
		ArrayList<ClaimBean> cbList=new ArrayList<ClaimBean>();
		try {		
			
			//first searching from domiciliary claim tables
			st=con.prepareStatement("select * from domclaim where status=0");
			rs=st.executeQuery();
			while(rs.next()){
				int hid=rs.getInt("empHiId");
				cb=new ClaimBean();
				cb.setClaimType("Domiciliary");
				cb.setPatientName(rs.getString("benefName"));
				cb.setMediAssistClaimNo(rs.getInt("domClmId"));
				cb.setRelation(getRelationDep(hid,con));
				cb.setClaimAmt(rs.getDouble("totalClaimAmt"));
				cb.setApprovedAmt(rs.getDouble("approvedAmt"));
				cb.setStatus(rs.getInt("status"));
				cbList.add(cb);
			}
			
			//searching from hospitalization claim tables
			st=con.prepareStatement("select * from hosclaim where status=0");
			rs=st.executeQuery();
			while(rs.next()){
				cb=new ClaimBean();
				cb.setClaimType("Hospitalization");
				cb.setPatientName(rs.getString("nameOfPatient"));
				cb.setMediAssistClaimNo(rs.getInt("hosClmId"));
				cb.setRelation(rs.getString("relationship"));
				cb.setClaimAmt(rs.getDouble("totalClaimAmt"));
				cb.setApprovedAmt(rs.getDouble("approvedAmt"));
				cb.setStatus(rs.getInt("status"));
				cbList.add(cb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return cbList;
	}
	
	//Approvals
	public ArrayList<EmployeeBean> getEmpDetailApproval(){
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		EmployeeBean emp=null;
		con = DbTransaction.getConnection();
		ArrayList<EmployeeBean> empList=new ArrayList<EmployeeBean>();
		try{
			st=con.prepareStatement("select * from Employee where status=0");
			rs=st.executeQuery();
			while(rs.next()){
				emp=new EmployeeBean();
				emp.setEmp_id(rs.getInt("id"));
				emp.setEmp_hi_id(rs.getInt("hi_id"));
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
				empList.add(emp);
				
			}
		}catch (SQLException s) {
			s.printStackTrace();
		}
		DbTransaction.closeConnection(con);
		return empList;
	}
	
	public void setEmpStatus(int hid){
	
		Connection con=null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		try {
			st=con.prepareStatement("update Employee set status=1 where hi_id=?");
			st.setInt(1, hid);
			a=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==1){
			System.out.println("Employee approved");
		}
		else
			System.out.println("Employee not approved");
	}
	
	public ArrayList<DependentBean> getDepDetailApproval(){
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		DependentBean db=null;
		con = DbTransaction.getConnection();
		ArrayList<DependentBean> depList=new ArrayList<DependentBean>();
		try {
			st=con.prepareStatement("select * from dependents where status=0");
			rs=st.executeQuery();
			while(rs.next()){
				db=new DependentBean();
				db.setDep_hi_id(rs.getInt("hi_id"));
				db.setDep_id(rs.getInt("emp_id"));
				db.setDep_name(rs.getString("name"));
				db.setDep_relation(rs.getString("relation"));
				db.setDep_dob(rs.getString("dob"));
				db.setDep_gender(rs.getString("gen"));
				db.setDep_policy_start_date(rs.getString("policy_start_date"));
				db.setDep_policy_period(rs.getInt("policy_period"));
				db.setDep_tot_sum_ins(rs.getDouble("tot_sum_ins"));
				db.setDep_prem_amt(rs.getDouble("prem_amt"));
				db.setStatus(rs.getInt("status"));
				depList.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return depList;
	}
	
	public void setDepStatus(int hid){
		
		Connection con=null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		try {
			st=con.prepareStatement("update dependents set status=1 where hi_id=?");
			st.setInt(1, hid);
			a=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==1){
			System.out.println("Dependent approved");
		}
		else
			System.out.println("Dependent not approved");
	}
	
	public void setClaimStatus(int claimNo,double appAmt){
		Connection con=null;
		PreparedStatement st=null;
		int a=0;
		con=DbTransaction.getConnection();
		try {
			//setting status for hosclaim
			st=con.prepareStatement("update HOSCLAIM set status=1,approvedAmt=? where hosclmid=?");
			st.setDouble(1, appAmt);
			st.setInt(2, claimNo);
			a=st.executeUpdate();
			if(a==1){
				System.out.println("status set in hosclaim");
			}else{
				System.out.println("status not set in hosclaim");
			}
			
			//setting status for domclaim
			st=con.prepareStatement("update DOMCLAIM set status=1,approvedAmt=? where domClmId=?");
			st.setDouble(1, appAmt);
			st.setInt(2, claimNo);
			a=st.executeUpdate();
			if(a==1){
				System.out.println("status set in domclaim");
			}else{
				System.out.println("status not set in domclaim");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}