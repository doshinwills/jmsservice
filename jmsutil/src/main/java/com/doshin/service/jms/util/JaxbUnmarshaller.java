package com.doshin.service.jms.util;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.doshin.service.jms.model.RequestVO;

public class JaxbUnmarshaller {

	public static RequestVO unmarshal(String xml) {
		RequestVO requestVO = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(RequestVO.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			requestVO = (RequestVO) jaxbUnmarshaller.unmarshal(sr);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return requestVO;
	}

}
