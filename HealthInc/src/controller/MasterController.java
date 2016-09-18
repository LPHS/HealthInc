package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeeBean;
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
		String source=request.getParameter("source");
		if(source!=null)
		{
			if(source.equals("empUpdate"))
			{
				HttpSession session=request.getSession();
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
					response.sendRedirect("/HealthInc/UpdateSuccessfull.jsp");
				}
				
				else
					
				{
					response.sendRedirect("/HealthInc/UpdateSuccessfull.jsp");
				}
				

			}
			
			
		}
		
	}

}
