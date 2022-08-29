package code.service;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import code.dao.StateDetailDao;
import code.pojo.StateAllDetail;
import code.pojo.StatePojo;

public class RequestHandler {

	public String getStateXml() {

		StateDetailDao stDao = new StateDetailDao();

		List<StatePojo> list = stDao.getStateList();
		System.out.println("list send from server side");
		String listXML = genrateXml(list).toString();

		return listXML;
	}

	private String genrateXml(List<StatePojo> list) {
		StateAllDetail sDetail = new StateAllDetail();

		sDetail.setList(list);

		try {
			JAXBContext jc = JAXBContext.newInstance(StateAllDetail.class);

			Marshaller cm = jc.createMarshaller();

			StringWriter sWriter = new StringWriter();
			
			cm.marshal(sDetail, sWriter);
			
			return sWriter.toString();

		} catch (Exception e) {
			System.out.println("RequestHandler.genrateXml() get some exception");
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
	public static void main(String[] args) {
		RequestHandler requestHandler=new RequestHandler();
		String sys = requestHandler.getStateXml();
		
		System.out.println(sys);
	}
}
