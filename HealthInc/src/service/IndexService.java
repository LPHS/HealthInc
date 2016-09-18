package service;

import bean.DependentBean;
import bean.EmployeeBean;
import dao.Dao;

public class IndexService {
	
	Dao d=new Dao();
	
	public boolean checkEmpLogin(String id, String pass){
		return d.checkEmpLogin(id,pass);
	}
	
	public boolean checkAdminLogin(String id, String pass){
		return d.checkAdminLogin(id,pass);
	}
	
	public boolean registerEmployee(EmployeeBean e){
		return d.registerEmployee(e);
	}
	
	public EmployeeBean getEmpDetail(String id){
		return d.getEmpDetail(id);
	}

	public boolean updateEmployee(EmployeeBean e) {
		return d.updateEmployee(e);
		
	}
	
	public boolean registerDependent(DependentBean d){
		return d.registerDependent(d);
	}
}
