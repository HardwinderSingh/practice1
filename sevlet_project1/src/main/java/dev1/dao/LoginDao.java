package dev1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dev1.encription.Encription;
import dev1.operations.Finalvariables;

public class LoginDao {
	public static String updateCounter(String uid,String count) {
		System.out.println("run update counter");
		try {
			
			Connection con = ConnectionClass.connection();
			int counter=Integer.parseInt(count);
			if (counter <= 3 ) {
				System.out.println("wrong pass counte less than 3");
				PreparedStatement ps = con.prepareStatement(" update lgn_mst set logcount=? where uid=?");	
				counter+=1;
				ps.setString(1, counter+"");//increase counter by one
				ps.setString(2, uid);
				int re=ps.executeUpdate();
				if (re>0) {
					return Finalvariables.WRONGPASS;
				}
			}
			else {
				System.out.println("wrong pass more than 3 lock cont");
				PreparedStatement ps = con.prepareStatement(" update lgn_mst set status=? logcount=? where uid=?");	
				ps.setString(1, "L");
				ps.setString(2, (counter+=1)+"");//increase counter by one
				ps.setString(3, uid);
				int re=ps.executeUpdate();
				if (re>0) {
					return Finalvariables.USERLOCK;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Finalvariables.ERROR+" in counter";
	}
	public static String updateLogin(String uid) {
		try {
			System.out.println("run update log in()");
			Connection con = ConnectionClass.connection();
			PreparedStatement ps = con.prepareStatement("update lgn_mst set logcount=?,status=? where uid=?");
			ps.setString(1, "0");
			ps.setString(2, "N");
			ps.setString(3, uid);
			int re = ps.executeUpdate();
			if (re > 0) {
				return Finalvariables.SUCCESS;
			}
		} catch (Exception e) {
			System.out.println(Finalvariables.ERROR+" update Login");
			// TODO: handle exception
		}
		return Finalvariables.ERROR + "to update counter";

	}

	public static String storeOtp(String mobile, String otp) {
		try {
			System.out.println("run ot store()");
			Connection con = ConnectionClass.connection();
			PreparedStatement ps = con.prepareStatement("update lgn_mst set otp=? where mobile=?");
			ps.setInt(1, Integer.parseInt(otp));
			ps.setString(2, mobile);
			int re = ps.executeUpdate();
			if (re > 0)
				return otp;

		} catch (Exception e) {
			System.out.println("error in store otp in location dao");
			// TODO: handle exception

		}
		return "invalid no";

	}

	public static String logIn(String name, String pass, String mobile, String otp) {
		try {

			Connection con = ConnectionClass.connection();
			PreparedStatement ps = con.prepareStatement("select * from lgn_mst where uid=?");
			ps.setString(1, name);
			ResultSet data = ps.executeQuery();

			while (data.next()) {

				String datamobile = data.getString("mobile");
				String datapassword = data.getString("pass");
				String dataStatus = data.getString("status");
				String dataCounter= data.getString("logcount");
				String dataOtp=data.getString("otp");

				String encriptpass = Encription.encryptionPassword(pass);
				/* check password */
				
				if (!datapassword.equalsIgnoreCase(encriptpass)) {
					/* Update counter */
					
					return updateCounter(name, dataCounter);
				}
				/* check mobile */
				if (!datamobile.equalsIgnoreCase(mobile)) {
					return Finalvariables.WRONGMOBILE;
				}
				if(!dataOtp.equalsIgnoreCase(otp)) {
					return Finalvariables.OTPNOTMATCH;
				}
				if (dataStatus.equals("N") || dataStatus.equals("n")) {
					return Finalvariables.ALERDYLOGIN;
				}
				if (dataStatus.equals("L") || dataStatus.equals("l")) {
					return Finalvariables.USERLOCK;
				}
				/* if meet all requirement */
				if (datapassword.equals(encriptpass)) {
					
					return updateLogin(name);

				} else {

					System.out.println("run else part in LOGINDAO.login");
					return Finalvariables.ERROR;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Finalvariables.ERROR);
			// TODO: handle exception

		}
		return Finalvariables.USERNOTAVALIABLE;

	}

}
