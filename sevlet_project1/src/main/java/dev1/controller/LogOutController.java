package dev1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev1.dao.LogOutDAO;

/**
 * Servlet implementation class LogOutController
 */
@WebServlet("/LogOutController")
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// ServletContext con = getServletContext();
		// String uid = (String)con.getAttribute("userId");
		HttpSession t = request.getSession(false);
		if(t==null) {
			
			
		}else {
		String uid = (String) t.getAttribute("userId");

		System.out.println("Run logout " + uid);
		String ret = LogOutDAO.LogOu(uid);
		out.print("<h1>" + uid + "  " + ret + "<h1>");
		//t.removeAttribute("userId");
		t.removeAttribute("userId");
		}
		request.getRequestDispatcher("login.jsp").include(request, response);

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
