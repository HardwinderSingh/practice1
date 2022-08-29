package code.handler;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import code.Service.ServiceXmlProxy;
import code.dao.StateDetailDao;
import code.pojo.State;

@Path("serverSide")
public class RequestHandler {
	
	
	
	
	// http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/soatorest
	@POST
	@Path("soatorest")
	public String getdataSoaToRestXmlToJsonAllState() throws JSONException, JsonGenerationException, JsonMappingException, IOException {
		
		Map<String, String> map = new HashMap<String,String>();
		map.put("error", "process not complete yet");
		ObjectMapper objmapper = new ObjectMapper();
		String mappererror = objmapper.writeValueAsString(map);
		 
		
		return mappererror.toString();
		
	}

	// http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/soatorestbyid?id=
	@POST
	@Path("soatorestbyid")
	public String getsoatorest(@QueryParam("id") String id) throws RemoteException, JSONException {
		ServiceXmlProxy serviceXmlProxy = new ServiceXmlProxy();// WebserviceP2ServerSide
		String xmlList = serviceXmlProxy.getStatebyIdinXml(id);
		JSONObject jsonList = XML.toJSONObject(xmlList);
		return jsonList.toString();

	}

	// http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/allstateJson
	@POST
	@Path("allstateJson")
	public String getStateByJsonArry()
			throws JSONException, JsonGenerationException, JsonMappingException, IOException {
		StateDetailDao statedaoObject = new StateDetailDao();
		List<State> list = statedaoObject.getStateList();
		ObjectMapper objMapper = new ObjectMapper();
		String slist = objMapper.writeValueAsString(list);

		return slist;

	}

	// http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/allstate
	@POST
	@Path("allstate")
	public String getStateList() throws JSONException {
		StateDetailDao statedaoObject = new StateDetailDao();
		JSONArray jsonlist = statedaoObject.getStateListjson();

		return jsonlist.toString();
	}

	// http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/method

	@POST
	@Path("method")
	public String Method_1(@QueryParam("data") String data) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", data);
		jsonObject.put("phone no", "9876543210");

		return jsonObject.toString();
	}

	// http://localhost:7080/WebService-jersey-P1-ServerSide/container/serverSide/state?code=
	@POST
	@Path("state")
	public String StateListBycode(@QueryParam("code") String code) throws JSONException {
		StateDetailDao statedao = new StateDetailDao();
		String json = statedao.getStateList(code);
		System.out.println(json);

		return json.toString();
	}
}
