package dev1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashSet;
import java.util.Set;

import dev1.beans.DistrictBean;
import dev1.beans.StateBean;
import dev1.operations.Finalvariables;

public class LocationDao {

	public static Set<DistrictBean> getDisticSetByStatecode(String stateCode) {
		try {
			System.out.println("LocationDao.getDisticSetByStatecode()" + " code is " + stateCode);
			
			Set<DistrictBean> set=new LinkedHashSet<DistrictBean>();
			Connection connection = ConnectionClass.connection();
			PreparedStatement ps = connection.prepareStatement("select * from mst_district where state_code=?");
			ps.setString(1, stateCode);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DistrictBean districtBean=new DistrictBean();
				districtBean.setDistrictCode(rs.getString("district_code"));
				districtBean.setDistrictName(rs.getString("district_name"));
				set.add(districtBean);
			}
			return set;
		} catch (Exception e) {
			System.out.println(Finalvariables.ERROR+"in location dao.getdidtrictsetby statecode");
			// TODO: handle exception
		}
		return null;
		
	}

	public static StateBean getStateNameByShortName(String sName) {
		
		try {
			System.out.println("LocationDao.getStateNameByShortName() id is-" + sName);
			
			StateBean stateBean=new StateBean();
			Connection con = ConnectionClass.connection();
			PreparedStatement ps = con.prepareStatement("select * from mst_state where state_short_name=?");
			ps.setString(1, sName);
			ResultSet data = ps.executeQuery();
			while (data.next()) {
				
				stateBean.setStName(data.getString("state_name"));
				stateBean.setStCode(data.getString("state_code"));
				stateBean.setStShortName(data.getString("state_short_name"));
				
			}
			return stateBean;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Set<StateBean> getState() {
		Set<StateBean> stateDataSet = new LinkedHashSet<StateBean>();

		try {

			Connection con = ConnectionClass.connection();
			PreparedStatement ps = con.prepareStatement("select * from mst_state order by state_name");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				StateBean stateBeans = new StateBean();
				stateBeans.setStCode("" + rs.getInt("state_code"));
				stateBeans.setStName(rs.getString("state_name"));
				stateBeans.setStShortName(rs.getString("state_short_name"));
				stateDataSet.add(stateBeans);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return stateDataSet;

	}

}
