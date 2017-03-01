package com.doshin.service.jms.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbMarsheller {

	public static String marshal(Object obj, Class<?> type) {
		JAXBContext jaxbContext = null;
		StringWriter sw = null;
		try {
			jaxbContext = JAXBContext.newInstance(type);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			sw = new StringWriter();
			jaxbMarshaller.marshal(obj, sw);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
		return sw.toString();
	}

}
