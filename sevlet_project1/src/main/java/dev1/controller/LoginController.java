package dev1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev1.dao.LoginDao;
import dev1.operations.Finalvariables;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String C_NAME = request.getParameter("C_STATE") + "_" + request.getParameter("C_NAME");
		// String C_STATE= request.getParameter("C_STATE");
		String C_PASS = request.getParameter("C_PASS");
		String C_MOBILE = request.getParameter("C_MOBILE");
		String C_OTP = request.getParameter("C_OTP");
		String datacheck = LoginDao.logIn(C_NAME, C_PASS, C_MOBILE, C_OTP);

		if (datacheck.equals(Finalvariables.SUCCESS)) {
			
			//ServletContext con = getServletContext();
			//con.setAttribute("userId", C_NAME);
			//con.setAttribute("mobile", C_MOBILE);
			HttpSession t=request.getSession();
			t.setAttribute("userId", C_NAME);
			t.setAttribute("mobile", C_MOBILE);
			out.println(Finalvariables.HEADERSUCCESFULL);
			request.getRequestDispatcher("user.jsp").include(request, response);
		} else {
			out.println("<h1>" + datacheck + "</h1>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
