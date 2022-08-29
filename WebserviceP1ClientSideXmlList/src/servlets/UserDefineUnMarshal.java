package servlets;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pojo.StateAllDetail;

public class UserDefineUnMarshal {
public StateAllDetail UnmarshaiXml(String Xmldata) throws JAXBException{
	 JAXBContext jsxbContext = JAXBContext.newInstance(StateAllDetail.class);
	Unmarshaller unmarshaller = jsxbContext.createUnmarshaller();
	 StringReader readerData = new StringReader(Xmldata);
	  StateAllDetail data = (StateAllDetail) unmarshaller.unmarshal(readerData);
	return data;

}
}
