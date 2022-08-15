package dev1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class signupDAO {
public String storeData(String uid,String pass,String mobile,int otp) {
	try {
		Connection con = ConnectionClass.connection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO lgn_mst("
				+ "	            uid, pass, mobile, otp, logcount, status)"
				+ "	    VALUES (?, ?, ?, ?, '0', 'Y')");
		
		
		
		
		ps.setString(1, uid);
		ps.setString(2, pass);
		ps.setString(3, mobile);
		ps.setInt(4, otp);
		
		
		
		 int a = ps.executeUpdate();
		if(a>0) {
			return "insert";
		}
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return " not insert";
	
}
}
