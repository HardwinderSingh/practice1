package dev1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev1.beans.ChildBean;
import dev1.beans.ParentsBean;
import dev1.dao.DataStoreDAO;
import dev1.operations.Finalvariables;

/**
 * Servlet implementation class DetailEnteryController
 */
@WebServlet("/DetailEnteryController")
public class DetailEnteryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ParentsBean parentsBean=new ParentsBean();
		parentsBean.setP_NameString(request.getParameter("p_name"));
		parentsBean.setP_dobString(request.getParameter("p_date"));
		parentsBean.setP_GenderString(request.getParameter("p_gender"));
		parentsBean.setP_StateCodeString(request.getParameter("p_state"));
		parentsBean.setP_DistrictCodeString(request.getParameter("p_district"));
		
		ChildBean childBean=new ChildBean();
		childBean.setC_name(request.getParameterValues("c_name"));
		childBean.setC_adhar(request.getParameterValues("c_adhar"));
		childBean.setC_age(request.getParameterValues("c_age"));
		
	boolean	returnData=DataStoreDAO.storeUserData(parentsBean, childBean);
		if (returnData) {
			out.print("<h1>"+Finalvariables.DONE+"</h1>");
			request.getRequestDispatcher("user.jsp").include(request, response);
		}
		else {
			out.print("<h1>"+Finalvariables.ERROR+"</h1>");
			request.getRequestDispatcher("user.jsp").include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
