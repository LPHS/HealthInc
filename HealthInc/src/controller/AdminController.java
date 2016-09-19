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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				if(source.equals("claimApproval"))
				{
					ArrayList<ClaimBean> obj= new ArrayList<ClaimBean>();
					obj=is.returnApprovalClaims();
					if(obj.size()>0)
					{
						
					}
					else{
					response.sendRedirect("/HealthInc/NoClaim.jsp");
					}
					
				}
				if(source.equals("employeeApproval"))
				{
					response.sendRedirect("/HealthInc/AdminEmployeeApproval.jsp");
					
				}
				if(source.equals("dependentApproval"))
				{
					response.sendRedirect("/HealthInc/AdminDependentApproval.jsp");
					
				}
				
				
			}
		
		
	}

}
