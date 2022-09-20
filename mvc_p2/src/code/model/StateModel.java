package code.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_state")
public class StateModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="state_code")
	private Integer state_code;
	@Column(name="state_name")
	private String state_name;
	@Column(name="state_short_name")
	private String state_short_name;
	public Integer getState_code() {
		return state_code;
	}
	public void setState_code(Integer state_code) {
		this.state_code = state_code;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public String getState_short_name() {
		return state_short_name;
	}
	public void setState_short_name(String state_short_name) {
		this.state_short_name = state_short_name;
	}
	
}
