package code.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import code.bean.StateDataPojo;

/**
 * Servlet implementation class StateData
 */
@WebServlet("/StateData")
public class StateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		List<StateDataPojo> list=new ArrayList<StateDataPojo>();
		try {
			Client client=new Client();
			WebResource resource = client.resource("http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/allstate");
			ClientResponse cr = resource.accept("application/text").post(ClientResponse.class);
			String data = cr.getEntity(String.class);
			System.out.println(data);
			
			
			JSONArray jsonarray = new JSONArray(data);
			out.print("<h1>Sucessful</h1><br>");
			for(int i=0;i<=jsonarray.length();i++) {
				 JSONObject jsonObject = jsonarray.getJSONObject(i);
				 StateDataPojo statepojo = new StateDataPojo();
				 statepojo.setState_code(jsonObject.getString("State_code"));
				 statepojo.setState_name(jsonObject.getString("State_name"));
				 statepojo.setState_shot_name(jsonObject.getString("State_shot_name"));
				 list.add(statepojo);
				 
				out.print("<br><p>"+jsonObject.getString("State_code")+"  "+jsonObject.getString("State_name")+"  "+jsonObject.getString("State_shot_name")+"</p>");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
