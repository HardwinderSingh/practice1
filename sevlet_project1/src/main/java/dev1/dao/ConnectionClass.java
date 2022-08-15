package dev1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionClass {
	private static Connection con = null;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			String link = "jdbc:postgresql://localhost:5433/postgres";
			String name = "postgres";
			String passString = "Dhillon93";
			con = DriverManager.getConnection(link, name, passString);
		} catch (Exception e) {
			// TODO: handle excepti

		}
	}

	public static Connection connection() {
		return con;
	}
	
	public static int getMaxCID(Connection com) {
		try {
			PreparedStatement ps = com.prepareStatement("select  max(cid) as cd from c_mst1");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String t = rs.getString("cd");
				return Integer.parseInt(t) + 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
