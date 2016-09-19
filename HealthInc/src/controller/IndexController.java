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

@WebServlet("/IndexController")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
		request.setAttribute("msg", "Logged out succesfully");
		rd.forward(request, response);

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IndexService is = new IndexService();
		String source = request.getParameter("source");
		if (source != null) {
			if (source.equals("registration")) {
				response.sendRedirect("/HealthInc/EmpRegistration.jsp");
			} else if (source.equals("adminLoginRedirect")) {
				System.out.println("admin login redirect in controller");
				response.sendRedirect("/HealthInc/AdminLogin.jsp");
			} else if (source.equals("back")) {
				response.sendRedirect("/HealthInc/Index.jsp");
			} else if (source.equals("register")) {
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
					response.sendRedirect("/HealthInc/RegistrationSuccessful.jsp");
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
					request.setAttribute("msg", "Registration Failed");
					rd.forward(request, response);
				}
			} else if (source.equals("empLogin")) {
				String id = request.getParameter("id");
				String pass = request.getParameter("pass");

				/* Checking Login Details */
				boolean flag = is.checkEmpLogin(id, pass);
				if (flag == true) {
					EmployeeBean e = is.getEmpDetail(id);

					/* Setting session */
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("hid", e.getEmp_hi_id());
					response.sendRedirect("/HealthInc/EmpHome.jsp");
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/Index.jsp");
					request.setAttribute("msg", "Login Failed");
					rd.forward(request, response);
				}
			} else if (source.equals("adminLogin")) {
				System.out.println("In admin login controller");
				String id = request.getParameter("id");
				String pass = request.getParameter("pass");

				/* Checking Login Details */
				boolean flag = is.checkAdminLogin(id, pass);
				if (flag == true) {

					/* Setting Session */
					HttpSession session = request.getSession();
					session.setAttribute("id", id);

					response.sendRedirect("/HealthInc/AdminHome.jsp");
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/AdminLogin.jsp");
					request.setAttribute("msg", "Login Failed");
					rd.forward(request, response);
				}

			}
		}
	}
}
