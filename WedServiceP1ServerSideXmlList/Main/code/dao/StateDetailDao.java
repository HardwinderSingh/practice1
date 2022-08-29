package code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import code.pojo.StatePojo;

public class StateDetailDao {
public List<StatePojo> getStateList() {
System.out.println("inside pojo ");
	List<StatePojo> list=new ArrayList<>();
	Connection connection=ConnectionClass.connection();
	
	try {
		
		PreparedStatement ps = connection.prepareStatement("Select * from mst_state");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			StatePojo statepojo = new StatePojo();
			statepojo.setState_code(rs.getInt(1));
			statepojo.setState_name(rs.getString(2));
			statepojo.setState_short_name(rs.getString(3));
			list.add(statepojo);
		
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("error in state dao");
		e.printStackTrace();
	}
	System.out.println("list return in pojo");
	return list;  
	
}
}
