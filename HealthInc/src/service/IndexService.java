package service;

import bean.EmployeeBean;

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
}
