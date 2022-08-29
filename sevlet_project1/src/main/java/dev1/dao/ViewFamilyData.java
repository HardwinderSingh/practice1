package dev1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev1.dto.ChildrenDto;
import dev1.dto.ParentsDto;
import dev1.operations.Finalvariables;

public class ViewFamilyData {
public Map<ParentsDto,List<ChildrenDto>> getFatherData() {
	Map<ParentsDto,List<ChildrenDto>> family=new HashMap<>();
	Connection	con =ConnectionClass.connection();
 	try {
 		PreparedStatement ps = con.prepareStatement("select f.fid, f.name,f.gndr,f.dob,s.state_name,d.district_name from f_mst1 as f inner join mst_state as s on f.stcode :: int=s.state_code inner join mst_district as d on f.distcode=d.district_code ");
 		ResultSet rs = ps.executeQuery();
 		while(rs.next()) {
 			ParentsDto pdto=new ParentsDto();
 			Integer fuid=rs.getInt("fid");
 			pdto.setP_name(rs.getString("name"));
 			pdto.setP_gender(rs.getString("gndr"));
 			pdto.setP_state(rs.getString("state_name"));
 			pdto.setP_district(rs.getString("district_name"));
 			pdto.setP_dob(rs.getString("dob"));
 			List<ChildrenDto>	list=getChildData(fuid);
 			family.put(pdto, list);
 		}
 		
 		
 		
	} catch (Exception e) {
		System.out.println(Finalvariables.ERROR+"view family .getData");
		// TODO: handle exception
	}
	return family;
	
}
public List<ChildrenDto> getChildData(Integer uid) {
	Connection	con =ConnectionClass.connection();
	List<ChildrenDto> list=new ArrayList<ChildrenDto>();	
	try {
		PreparedStatement ps = con.prepareStatement("select * from c_mst1 where fid=?");
		ps.setInt(1, uid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ChildrenDto childDto=new ChildrenDto();
			childDto.setC_name(rs.getString("name"));
			childDto.setC_age(rs.getString("age"));
			childDto.setAdhar(rs.getString("adhar"));
			list.add(childDto);
		}
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return list;
	
	
}
}
