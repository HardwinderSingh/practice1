package dev1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dev1.beans.ChildBean;
import dev1.beans.ParentsBean;
import dev1.operations.Finalvariables;

public class DataStoreDAO {
public static boolean storeUserData(ParentsBean pData,ChildBean cData) {
	System.out.println("DataStoreDAO.storeUserData()");
	Connection con = ConnectionClass.connection();
	int maxid = ConnectionClass.getMaxCID(con);
	try {
		System.out.println("start parents data store");
		con.setAutoCommit(false);
		PreparedStatement ps = con.prepareStatement("insert into f_mst1 values (?,?,?,?,?,?)");
				ps.setInt(1, maxid);
				ps.setString(2, pData.getP_NameString());
				ps.setString(3, pData.getP_GenderString());
				ps.setString(4, pData.getP_StateCodeString());
				ps.setString(5, pData.getP_DistrictCodeString());
				ps.setString(6,pData.getP_dobString());
				
		int i = ps.executeUpdate();
		if (i>0) {
			System.out.println("DataStoreDAO.storeUserData() after parentdata");
			String[] name= cData.getC_name();
			String[] age= cData.getC_age();
			String[] adhar= cData.getC_adhar();
			int c_index=maxid;
			ps = con.prepareStatement("insert into c_mst1 values (?,?,?,?,?)");
			for (int j = 0; j < adhar.length; j++) {
				ps.setInt(1, ++c_index);
				ps.setString(2 , name[j]);
				ps.setString(3, age[j]);
				ps.setString(4, adhar[j]);
				ps.setInt(5, maxid);
				ps.addBatch();
				
			}
			int[] t = ps.executeBatch();
			if (t.length > 0) {
				System.out.println("DataStoreDAO.storeUserData() after child datastore");
				con.commit();
				return true;
			} else {
				con.rollback();
			}
			
			
			
			
			
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println(Finalvariables.ERROR+"data store");
		// TODO: handle exception
	}finally {
		try {
		con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	return false;
}
}
