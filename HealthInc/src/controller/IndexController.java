package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.IndexService;

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source=request.getParameter("source");
		if(source!=null && source.equals("logout")){
			HttpSession session=request.getSession();
			session.invalidate();
		}
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IndexService is=new IndexService();
		String source=request.getParameter("source");
		if(source!=null){
			if(source.equals("registration")){
				response.sendRedirect("/HealthInc/EmpRegistration.jsp");
			}
			else if(source.equals("adminLogin")){
				response.sendRedirect("/HealthInc/AdminLogin.jsp");
			}
			else if(source.equals("back")){
				response.sendRedirect("/HealthInc/Index.jsp");
			}
			else if(source.equals("register")){
				/*use request.getParameter() and set to employee bean e*/
				boolean flag=is.registerEmployee(e);
				if(flag==true){
					response.sendRedirect("/HealthInc/RegistrationSuccessful.jsp");
				}
				else{
					response.sendRedirect("/HealthInc/RegistrationFailed.jsp");
				}
			}
			else if(source.equals("empLogin")){
				String id=request.getParameter("id");
				String pass=request.getParameter("pass");
				
				/*Checking Login Details*/
				boolean flag=is.checkEmpLogin(id,pass);
				if(flag==true){
					EmployeeBean e=is.getEmpDetail(id);
					
					/*Setting session*/
					HttpSession session=request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("hid", e.getHid());
					response.sendRedirect("/HealthInc/EmpHome.jsp");
				}
				else{
					response.sendRedirect("/HealthInc/Index.jsp");
				}
			}
			else if(source.equals("adminLogin")){
				String id=request.getParameter("id");
				String pass=request.getParameter("pass");
				
				/*Checking Login Details*/
				boolean flag=is.checkAdminLogin(id,pass);
				if(flag==true){
					
					/*Setting Session */
					HttpSession session=request.getSession();
					session.setAttribute("id", id);
					
					response.sendRedirect("/HealthInc/AdminHome.jsp");
				}
				else{
					response.sendRedirect("/HealthInc/Index.jsp");
				}
				
			}
		}
	}
}
