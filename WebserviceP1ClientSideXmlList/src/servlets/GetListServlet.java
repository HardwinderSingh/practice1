package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import code.service.RequestHandlerProxy;
import pojo.StateAllDetail;
import pojo.StatePojo;

@WebServlet("/GetListServlet")
public class GetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		RequestHandlerProxy requestHandlerProxy = new RequestHandlerProxy();
		String list = requestHandlerProxy.getStateXml();
		//System.out.println(list);
		
		UserDefineUnMarshal unMarshal = new UserDefineUnMarshal();
		StateAllDetail pojoObject = null;
		try {
			pojoObject = unMarshal.UnmarshaiXml(list);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<StatePojo> pojolist = pojoObject.getList();
		
		out.print("<h1>List is </h1><br><br>" + pojolist);

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
