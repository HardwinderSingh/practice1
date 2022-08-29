package pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="india")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateAllDetail {
	@XmlElement(name="state")
	List<StatePojo> list;

	public List<StatePojo> getList() {
		return list;
	}

	public void setList(List<StatePojo> list) {
		this.list = list;
	}


}
