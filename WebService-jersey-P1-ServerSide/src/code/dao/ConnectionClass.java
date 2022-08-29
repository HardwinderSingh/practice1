package code.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	private static Connection con = null;
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			System.out.println("error in driver class");
			e.printStackTrace();
		}

		try {

			String link = "jdbc:postgresql://localhost:5433/postgres";
			String name = "postgres";
			String passString = "Dhillon93";
			con = DriverManager.getConnection(link, name, passString);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle excepti

		}
	}

	public static Connection connection() {
		return con;
	}

}
