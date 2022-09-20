package code.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_district")
public class DistrictModel {
	
	@Id
	String district_code;
	String district_name;
	String state_code;
public String getDistrict_code() {
	return district_code;
}
public void setDistrict_code(String district_code) {
	this.district_code = district_code;
}
public String getDistrict_name() {
	return district_name;
}
public void setDistrict_name(String district_name) {
	this.district_name = district_name;
}
public String getState_code() {
	return state_code;
}
public void setState_code(String state_code) {
	this.state_code = state_code;
}
}
