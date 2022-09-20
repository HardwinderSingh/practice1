package code.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mvc_p2_user")
public class UserStateModel {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer id;
	private String state;
	private String distict;
	private String name;
	private String phone_no;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getDistict() {
	return distict;
}
public void setDistict(String distict) {
	this.distict = distict;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}


}
