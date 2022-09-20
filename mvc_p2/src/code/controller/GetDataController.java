package code.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import code.dao.Getdata;
import code.model.DistrictModel;

@Controller
@RequestMapping("getData/")
public class GetDataController {
	
	
	
	@Autowired
	Getdata getdata;
	
	@RequestMapping(value="distData",method= RequestMethod.GET)
	public @ResponseBody String getDistrictData(@RequestParam("state_code")String state_code) throws JsonGenerationException, JsonMappingException, IOException{
		List<DistrictModel> districtList = getdata.getDistrictList(state_code);
/*		List<Object[]> districtList = getdata.getDistrictListbySql(state_code);
		for(Object[] a:districtList){
			//System.out.println(a.getDistrict_code()+" | "+a.getDistrict_name()+" | "+a.getState_code());
			System.out.println(a[0]+" | "+a[1]+" | "+a[2]);
		}
*/		ObjectMapper objectMapper=new ObjectMapper();
		String asString = objectMapper.writeValueAsString(districtList);
		return asString;
	}
}
