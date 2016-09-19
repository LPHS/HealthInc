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
import bean.DomiciliaryBean;
import bean.EmployeeBean;
import bean.HospitalizationBean;
import service.IndexService;


@WebServlet("/MasterController")
public class MasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IndexService is=new IndexService();
		HttpSession session=request.getSession();
		String source=request.getParameter("source");
		if(session!=null){
			if(source!=null)
			{
				if(source.equals("empUpdate"))
				{
					String id=(String)session.getAttribute("id").toString();
					System.out.println(id);
					EmployeeBean emp=new EmployeeBean();
					emp=is.getEmpDetail(id);
					System.out.println(emp.getEmp_bnk_name());
					request.setAttribute("emp",emp);
					RequestDispatcher rd=request.getRequestDispatcher("EmpUpdate.jsp");
					rd.forward(request,response);
				}
			
				//
				if(source.equals("update"))
				{
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
						response.sendRedirect("/HealthInc/UpdateSuccessful.jsp");
					}
				}
			
				//
				if(source.equals("addDependent")){
					response.sendRedirect("/HealthInc/EmpDepRegistration.jsp");				
				}
			
				//
				if(source.equals("register")){
					DependentBean d=new DependentBean();
					d.setDep_id(Integer.parseInt(session.getAttribute("id").toString()));
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
						response.sendRedirect("/HealthInc/DependentSuccessful.jsp");
					}
					else{
						response.sendRedirect("/HealthInc/OpearationFailed.jsp");
					}
				}
				
				if(source.equals("viewDependents")){
					ArrayList<DependentBean> dlist=new ArrayList<DependentBean>();
					String ids=(String)session.getAttribute("id").toString();
					System.out.println(ids);
					int id=Integer.parseInt(ids);
					dlist=is.getDependents(id);
					//System.out.println("Dependent list fetched"+dlist.get(0).getDep_id());
						request.setAttribute("deplist", dlist);
						RequestDispatcher rd=request.getRequestDispatcher("ViewDependents.jsp");
						rd.forward(request, response);
						
					
					
				}
				
				if(source.equals("Update Dependent"))
				{
					int dependent=Integer.parseInt(request.getParameter("d_id"));
					DependentBean dep=new DependentBean();
					dep=is.getDependentDetails(dependent);
					request.setAttribute("Dependent", dep);
					RequestDispatcher rd=request.getRequestDispatcher("EmpUpdateDependent.jsp");
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
						response.sendRedirect("/HealthInc/UpdateSuccessful.jsp");
					}
					
					else
					{
						response.sendRedirect("/HealthInc/OperationFailed.jsp");
					}
					
				}
				
				
				if(source.equals("Delete Dependent"))
				{
				//request.getParameter("d_id");
					int id=Integer.parseInt(request.getParameter("d_id"));
					if(is.deleteDependent(id))
					{
						response.sendRedirect("/HealthInc/DeleteSuccessfull.jsp");
					}
					
					else
					{
						response.sendRedirect("/HealthInc/OperationFailed.jsp");
					}
					
				}
				
				if(source.equals("empDelete"))
				{
					String id=(String)session.getAttribute("id").toString();
					System.out.println(id);
					EmployeeBean emp=new EmployeeBean();
					emp=is.getEmpDetail(id);
					System.out.println(emp.getEmp_bnk_name());
					request.setAttribute("emp",emp);
					RequestDispatcher rd=request.getRequestDispatcher("EmpDelete.jsp");
					rd.forward(request,response);
				}
				
				if(source.equals("delete"))
				{	String id=(String)session.getAttribute("id").toString();
				System.out.println(id);	
					if(is.deleteEmployee(id))
					{
						response.sendRedirect("/HealthInc/DeleteSuccessfull.jsp");
					}
				
					else
					{	
						response.sendRedirect("/HealthInc/OperationFailed.jsp");
					}
				}
				
				if(source.equals("domClaim")){
					ArrayList<DependentBean> depList=is.getDependents(Integer.parseInt(session.getAttribute("id").toString()));
					EmployeeBean emp=is.getEmpDetail(session.getAttribute("id").toString());
					RequestDispatcher rd=request.getRequestDispatcher("/DomiciliaryClaims.jsp");
					request.setAttribute("depList", depList);
					request.setAttribute("emp", emp);
					rd.forward(request, response);
				}
				
				if(source.equals("domSubmit")){
					DomiciliaryBean dom=new DomiciliaryBean();
					dom.setEmpId(Integer.parseInt(request.getParameter("empid")));
					dom.setBenefName(request.getParameter("benef_sel"));
					dom.setEmpHiId(Integer.parseInt(request.getParameter("hiid")));
					dom.setPhoneNumber(request.getParameter("mobilenum"));
					dom.setAddress(request.getParameter("address"));
					dom.setAltEmailId(request.getParameter("altemailid"));
					dom.setTrtStartDate(request.getParameter("trtstartdate"));
					dom.setTrtEndDate(request.getParameter("trtenddate"));
					dom.setDateOfInjuiry(request.getParameter("doi"));
					dom.setNameOfDoctor(request.getParameter("docname"));
					dom.setDetailsOfInjuiry(request.getParameter("injurytype"));
					dom.setTotalClaimAmt(Double.parseDouble(request.getParameter("totalclaimamt")));
					if(is.domClaim(dom))
					{
						response.sendRedirect("/HealthInc/ClaimRequest.jsp");
					}
					else
					{	
						response.sendRedirect("/HealthInc/OperationFailed.jsp");
					}	
				}
				
				if(source.equals("hospClaim")){
					ArrayList<DependentBean> depList=is.getDependents(Integer.parseInt(session.getAttribute("id").toString()));
					EmployeeBean emp=is.getEmpDetail(session.getAttribute("id").toString());
					RequestDispatcher rd=request.getRequestDispatcher("/HospitalizationClaims.jsp");
					request.setAttribute("depList", depList);
					request.setAttribute("emp", emp);
					rd.forward(request, response);
				}
				
				if(source.equals("hosSubmit")){
					HospitalizationBean hos=new HospitalizationBean();
					hos.setEmpName(request.getParameter("emp_name"));
			    	hos.setEmail(request.getParameter("email"));
			    	hos.setMobNo(request.getParameter("mob_no"));
			    	hos.setCompanyName(request.getParameter("name_company"));
			    	hos.setNameOfPatient(request.getParameter("patient_name"));
			    	hos.setGender(request.getParameter("gender"));
			    	hos.setRelationship(request.getParameter("relationship"));
			    	hos.setAge(Integer.parseInt(request.getParameter("age")));
			    	hos.setHiid(Integer.parseInt(request.getParameter("hi_id")));
			    	hos.setState(request.getParameter("state"));
			    	hos.setCity(request.getParameter("city"));
			    	hos.setHosName(request.getParameter("name_hospital"));
			    	hos.setAddress(request.getParameter("address"));
			    	hos.setDateOfAdmission(request.getParameter("admissiondate"));
			    	hos.setDateOfDischarge(request.getParameter("dischargedate"));
			    	hos.setNameOfDoctor(request.getParameter("doc_name"));
			    	hos.setDetailsOfInjury(request.getParameter("injurydetails"));
			    	hos.setReasonOfInjury(request.getParameter("injuryreason"));
			    	hos.setTotalClaimAmt(Double.parseDouble(request.getParameter("total_claim")));
					
					if(is.hosClaim(hos))
					{
						response.sendRedirect("/HealthInc/ClaimRequest.jsp");
					}
					else
					{	
						response.sendRedirect("/HealthInc/OperationFailed.jsp");
					}	
				}
				
				if(source.equals("searchClaim")){
					response.sendRedirect("/HealthInc/ClaimSearch.jsp");
				}

				if(source.equals("claimSubmit")){
					int hid=Integer.parseInt(request.getParameter("hi_id"));
					ArrayList<ClaimBean> cbList=is.claimSearch(hid);
					if(cbList.size()>0){
						RequestDispatcher rd=request.getRequestDispatcher("/ClaimSearchResult.jsp");
						request.setAttribute("cbList", cbList);
						rd.forward(request, response);
					}else{
						response.sendRedirect("/HealthInc/ClaimSearchFailed.jsp");
					}
				}
				
				if(source.equals("empBack")){
					response.sendRedirect("/HealthInc/EmpHome.jsp");
				}
			}
		}else{
			response.sendRedirect("SessionExpired.jsp");
		}
		
	}

}
