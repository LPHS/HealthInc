package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClaimBean;
import bean.DependentBean;
import bean.EmployeeBean;
import bean.Hospital;
import service.IndexService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		IndexService is=new IndexService();
		HttpSession session=request.getSession();
			String source=request.getParameter("source");
			if(source!=null)
				
			{
				
				if(source.equals("addHospital"))
				{
					response.sendRedirect("/HealthInc/AdminAddHospital.jsp");
					
				}
				
				if(source.equals("Add Hospital"))
				{
					Hospital h=new Hospital();
					h.setId(Integer.parseInt(request.getParameter("id")));
					h.setName(request.getParameter("name"));
					h.setAddress(request.getParameter("address"));
					h.setCity(request.getParameter("city"));
					h.setPhone(request.getParameter("phone"));
					h.setPin(Integer.parseInt(request.getParameter("pin")));
					h.setStd(Integer.parseInt(request.getParameter("std")));
					h.setState(request.getParameter("state"));
					if(is.addHospital(h))
					{
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
						
					}
					else
					{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
					
				}
				
				if(source.equals("viewHospital"))
				{
					response.sendRedirect("/HealthInc/AdminViewHospital.jsp");
					
				}
				
				if(source.equals("Update Hospital"))
				{
					int hid=Integer.parseInt(request.getParameter("id"));
					Hospital h=new Hospital();
					h=is.getHospital(hid);
					
					request.setAttribute("hospital",h);
					RequestDispatcher rd=request.getRequestDispatcher("AdminUpdateHospital.jsp");
					rd.forward(request, response);
				}
				
				if(source.equals("Update Hospital Details"))
				{
					Hospital h=new Hospital();
					h.setId(Integer.parseInt(request.getParameter("id")));
					h.setName(request.getParameter("name"));
					h.setAddress(request.getParameter("address"));
					h.setCity(request.getParameter("city"));
					h.setPhone(request.getParameter("phone"));
					h.setPin(Integer.parseInt(request.getParameter("pin")));
					h.setStd(Integer.parseInt(request.getParameter("std")));
					h.setState(request.getParameter("state"));
					System.out.println("hosp name to update:"+h.getName());
					boolean b=is.updateHospital(h);
					System.out.println(b);
					if(b)
					{	System.out.println(is.updateHospital(h));
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
						
					}
					else
					{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
				}
				
				if(source.equals("Delete Hospital"))
				{
					
					int hid=Integer.parseInt(request.getParameter("id"));
										
					if(is.deleteHospital(hid))
					{
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
					}
					else
					{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
				
				}
				
				if(source.equals("employeeApproval"))
				{
					ArrayList<EmployeeBean> empList=is.getEmpDetailApproval();
					RequestDispatcher rd=request.getRequestDispatcher("/AdminEmployeeApproval.jsp");
					request.setAttribute("empList", empList);
					rd.forward(request, response);
				}
				if(source.equals("ApproveEmp")){
					int hid=Integer.parseInt(request.getParameter("hid"));
					is.setEmpStatus(hid);			
					ArrayList<EmployeeBean> empList=is.getEmpDetailApproval();
					RequestDispatcher rd=request.getRequestDispatcher("/AdminEmployeeApproval.jsp");
					request.setAttribute("empList", empList);
					rd.forward(request, response);
				}
				if(source.equals("DependentApproval"))
				{
					ArrayList<DependentBean> depList=is.getDepDetailApproval();
					RequestDispatcher rd=request.getRequestDispatcher("/AdminDependentApproval.jsp");
					request.setAttribute("depList", depList);
					rd.forward(request, response);
					
				}
				if(source.equals("ApproveDep")){
					int hid=Integer.parseInt(request.getParameter("hid"));
					is.setDepStatus(hid);			
					ArrayList<DependentBean> depList=is.getDepDetailApproval();
					RequestDispatcher rd=request.getRequestDispatcher("/AdminDependentApproval.jsp");
					request.setAttribute("depList", depList);
					rd.forward(request, response);
				}
				if(source.equals("registration")){
					response.sendRedirect("/HealthInc/AdminEmpRegistration.jsp");
				}
				if(source.equals("register")){
					EmployeeBean e = new EmployeeBean();
					e.setEmp_name(request.getParameter("empName"));
					e.setEmp_id(Integer.parseInt(request.getParameter("empId")));
					e.setEmp_dob(request.getParameter("dob"));
					e.setEmp_gen(request.getParameter("gender"));
					e.setEmp_email(request.getParameter("mailId"));
					e.setEmp_alt_email(request.getParameter("altMailId"));
					e.setEmp_ph_no(request.getParameter("phnNo"));
					e.setEmp_mob_no(request.getParameter("altMobNo"));
					e.setEmp_policy_start_date(request.getParameter("polStDate"));
					e.setEmp_policy_period(Integer.parseInt(request.getParameter("polPeriod")));
					e.setEmp_tot_sum_ins(Double.parseDouble(request.getParameter("totSum")));
					e.setEmp_prem_amt(Double.parseDouble(request.getParameter("pamt")));
					e.setEmp_acc_no(request.getParameter("bankAccNo"));
					e.setEmp_bnk_name(request.getParameter("bankName"));
					e.setEmp_bnk_ifsc(request.getParameter("ifsc"));
					e.setEmp_password(request.getParameter("pwd"));

					boolean flag = is.registerEmployee(e);
					if (flag == true) {
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
					} else {
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
				}
				if(source.equals("employeeUpdate")){
					response.sendRedirect("/HealthInc/AdminEmpView.jsp");
				}
				if(source.equals("View Employee")){
					String id=request.getParameter("id");
					System.out.println(id);
					EmployeeBean emp=new EmployeeBean();
					emp=is.getEmpDetail(id);
					System.out.println(emp.getEmp_bnk_name());
					request.setAttribute("emp",emp);
					RequestDispatcher rd=request.getRequestDispatcher("AdminEmpUpdate.jsp");
					rd.forward(request,response);
				}
				if(source.equals("empUpdate")){
					EmployeeBean e=new EmployeeBean();
					e.setEmp_name(request.getParameter("empName"));
					e.setEmp_id(Integer.parseInt(request.getParameter("empId")));
					e.setEmp_dob(request.getParameter("dob"));
					e.setEmp_gen(request.getParameter("gender"));
					e.setEmp_email(request.getParameter("mailId"));
					e.setEmp_alt_email(request.getParameter("altMailId"));
					e.setEmp_ph_no(request.getParameter("phnNo")); 
					e.setEmp_mob_no(request.getParameter("altMobNo"));
					e.setEmp_policy_start_date(request.getParameter("polStDate")); 
					e.setEmp_policy_period(Integer.parseInt(request.getParameter("polPeriod")));
					e.setEmp_tot_sum_ins(Double.parseDouble(request.getParameter("totSum")));
					e.setEmp_prem_amt(Double.parseDouble(request.getParameter("pamt")));
					e.setEmp_acc_no(request.getParameter("bankAccNo"));
					e.setEmp_bnk_name(request.getParameter("bankName"));
					e.setEmp_bnk_ifsc(request.getParameter("ifsc"));
					e.setEmp_password(request.getParameter("pwd"));
					
				
					if(is.updateEmployee(e))
					{
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
					}else{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
					
				}
				if(source.equals("AdminAddDependent")){
					response.sendRedirect("AdminDepRegistration.jsp");
				}
				if(source.equals("adminDepRegister")){
					DependentBean d=new DependentBean();
					d.setDep_id(Integer.parseInt(request.getParameter("id")));
					d.setDep_name(request.getParameter("ben_name"));
					d.setDep_relation(request.getParameter("relation"));
					d.setDep_gender(request.getParameter("gender"));
					d.setDep_dob(request.getParameter("dob"));
					d.setDep_policy_start_date(request.getParameter("policy_startdate"));
					d.setDep_policy_period(Integer.parseInt(request.getParameter("policy_period")));
					d.setDep_tot_sum_ins(Double.parseDouble(request.getParameter("total_sum")));
					d.setDep_prem_amt(Double.parseDouble(request.getParameter("premium_amount")));
					boolean flag=is.registerDependent(d);
					if(flag==true){
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
					}
					else{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
				}
				if(source.equals("AdminDependents")){
					response.sendRedirect("/HealthInc/AdminDepEmpId.jsp");
				}
				if(source.equals("View Dependents")){
					ArrayList<DependentBean> dlist=new ArrayList<DependentBean>();
					String ids=request.getParameter("id");
					System.out.println(ids);
					int id=Integer.parseInt(ids);
					dlist=is.getDependents(id);
					//System.out.println("Dependent list fetched"+dlist.get(0).getDep_id());
						request.setAttribute("deplist", dlist);
						RequestDispatcher rd=request.getRequestDispatcher("AdminViewDependents.jsp");
						rd.forward(request, response);
				}
				if(source.equals("Update Dependent"))
				{
					int dependent=Integer.parseInt(request.getParameter("d_id"));
					DependentBean dep=new DependentBean();
					dep=is.getDependentDetails(dependent);
					request.setAttribute("Dependent", dep);
					RequestDispatcher rd=request.getRequestDispatcher("AdminEmpUpdateDependent.jsp");
					rd.forward(request, response);
				}
				
				if(source.equals("Update Dependent Details"))
				{
					DependentBean d=new DependentBean();
				//request.getParameter("d_id");
					d.setDep_hi_id(Integer.parseInt(request.getParameter("hi_id")));
					d.setDep_id(Integer.parseInt(session.getAttribute("id").toString()));
					d.setDep_name(request.getParameter("ben_name"));
					d.setDep_relation(request.getParameter("relation"));
					d.setDep_gender(request.getParameter("gender"));
					d.setDep_dob(request.getParameter("dob"));
					d.setDep_policy_start_date(request.getParameter("policy_startdate"));
					d.setDep_policy_period(Integer.parseInt(request.getParameter("policy_period")));
					d.setDep_tot_sum_ins(Double.parseDouble(request.getParameter("total_sum")));
					d.setDep_prem_amt(Double.parseDouble(request.getParameter("premium_amount")));
					
					if(is.updateDependentDetails(d))
					{
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
					}
					
					else
					{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
					
				}
				
				
				if(source.equals("Delete Dependent"))
				{
				//request.getParameter("d_id");
					int id=Integer.parseInt(request.getParameter("d_id"));
					if(is.deleteDependent(id))
					{
						response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
					}
					
					else
					{
						response.sendRedirect("/HealthInc/AdminOpFail.jsp");
					}
					
				}
				
				if(source.equals("deleteEmployee")){
					response.sendRedirect("/HealthInc/AdminDeleteEmployee.jsp");
				}
				if(source.equals("Delete Employee")){
					String id=request.getParameter("id");
					System.out.println(id);	
						if(is.deleteEmployee(id))
						{
							response.sendRedirect("/HealthInc/AdminOpSuccess.jsp");
						}
					
						else
						{	
							response.sendRedirect("/HealthInc/AdminOpFail.jsp");
						}
				}
				if(source.equals("claimApproval")){
					RequestDispatcher rd=request.getRequestDispatcher("AdminClaimApproval.jsp");
					ArrayList<ClaimBean> cbList=is.returnApprovalClaims();
					request.setAttribute("cbList", cbList);
					rd.forward(request, response);
				}
				if(source.equals("ApproveClaim")){
					int claimNo=Integer.parseInt(request.getParameter("claimNo"));
					double appAmt=Double.parseDouble(request.getParameter("appAmt"));
					is.setClaimStatus(claimNo, appAmt);
					RequestDispatcher rd=request.getRequestDispatcher("AdminClaimApproval.jsp");
					ArrayList<ClaimBean> cbList=is.returnApprovalClaims();
					request.setAttribute("cbList", cbList);
					rd.forward(request, response);
				}
				if(source.equals("adminBack")){
					response.sendRedirect("/HealthInc/AdminHome.jsp");
				}
				
				
			}
		
		
	}

}
