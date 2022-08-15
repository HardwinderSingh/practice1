package dev1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev1.dao.signupDAO;
import dev1.encription.Encription;





@WebServlet("/SignupController")
public class SignupController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
	
	PrintWriter out = response.getWriter();
	String uid=request.getParameter("state")+"_"+request.getParameter("uid");
	
	String pass=request.getParameter("pass");
	String mob=request.getParameter("mob");
	String otp=request.getParameter("otp");
	String pass2 = Encription.encryptionPassword(pass);
	out.println("<p>Your uid is= </p>"+uid);
	out.println("<p>password is= </p>"+pass);
	out.println("<p>encripted password is=</p>"+pass2);
	out.println(mob);

	
	signupDAO signupdao = new signupDAO();
	String returnvalue=signupdao.storeData(uid,pass2,mob,Integer.parseInt(otp));
	out.print("<p>value in database</p>"+returnvalue);
	request.getRequestDispatcher("home.jsp").include(request, response);
	
}
}
