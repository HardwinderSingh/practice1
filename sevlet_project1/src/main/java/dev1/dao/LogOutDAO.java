package dev1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dev1.operations.Finalvariables;

public class LogOutDAO {
	public static String LogOu(String Uid) {

		try {
			System.out.println("LogOutDAO.LogOu()"+Uid);
		Connection	con=ConnectionClass.connection();
		PreparedStatement ps = con.prepareStatement("update lgn_mst set status=? where uid=?");
		ps.setString(1, "Y");
		ps.setString(2, Uid);
		int ret=ps.executeUpdate();
		if (ret>0) {
			System.out.println("user log out");
			return Finalvariables.LOGOUT;
		}
		} catch (Exception e) {
			System.out.println(Finalvariables.ERROR+"user not log out");
			// TODO: handle exception
		}
		return Finalvariables.ERROR;
	}
	public void updateLock() {
		try {

			Connection con = ConnectionClass.connection();
			PreparedStatement ps = con.prepareStatement("update lgn_mst set status = ? ,logcount=? where status=?");
			ps.setString(1, "Y");
			ps.setString(2, "0");
			ps.setString(3, "L");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
