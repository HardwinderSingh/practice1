package dev1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev1.dao.LoginDao;
import dev1.operations.OperationClass;

/**
 * Servlet implementation class OtpController
 */
@WebServlet("/OtpController")
public class OtpController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String phone = request.getParameter("phone");
		String otp = OperationClass.genrateOtp(phone);
		if(otp.substring(0, 1).equals("0")) {
			System.out.println("otp start with zero retry");
			otp=OperationClass.genrateOtp(phone);
		}
		if(otp.substring(0, 1).equals("0")) {
			System.out.println("otp start with zero retry");
			otp=OperationClass.genrateOtp(phone);
		}
		String retrnOtp = LoginDao.storeOtp(phone, otp);
		
		System.out.println("call get otp" + phone + " otp is= " + otp + "   return value is " + retrnOtp);
		out.print(retrnOtp);
	}

}
