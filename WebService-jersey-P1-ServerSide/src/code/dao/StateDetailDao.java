package code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import code.pojo.State;

public class StateDetailDao {
	public List<State> getStateList() {
		Connection con = ConnectionClass.connection();
		List<State> list = new ArrayList<State>();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from mst_State");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				State state = new State();
				state.setState_code(rs.getInt(1));
				state.setState_name(rs.getString(2));
				state.setState_shot_name(rs.getString(3));
				list.add(state);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	public JSONArray getStateListjson() throws JSONException {
		Connection con = ConnectionClass.connection();
		JSONArray jsonarray = new JSONArray();
		try {
			PreparedStatement ps = con.prepareStatement("Select * from mst_State");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				JSONObject json = new JSONObject();
				json.put("State_code",""+rs.getInt(1)+"" );
				json.put("State_name", rs.getString(2));
				json.put("State_shot_name", rs.getString(3));
				jsonarray.put(json);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonarray;

	}


	public String getStateList(String code) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Connection connection = ConnectionClass.connection();

		try {
			int scode = Integer.parseInt(code);

			PreparedStatement ps = connection.prepareStatement("Select * from mst_state where state_code=? ");
			ps.setInt(1, scode);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String code1 = rs.getInt(1) + "";
				jsonObject.put("State_code", code1);
				jsonObject.put("State_name", rs.getString(2));
				jsonObject.put("State_short_name", rs.getString(3));

			}
			System.out.println("dao3" + jsonObject);
			return jsonObject.toString();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in state dao");
			e.printStackTrace();
		}
		System.out.println("list return in pojo");
		return null;

	}

}
