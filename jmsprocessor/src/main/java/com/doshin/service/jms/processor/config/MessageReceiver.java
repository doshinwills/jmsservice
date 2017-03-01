package com.doshin.service.jms.processor.config;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.doshin.service.jms.model.RequestVO;
import com.doshin.service.jms.util.JaxbUnmarshaller;
import com.doshin.service.jms.util.ServiceExecutor;

@Component
public class MessageReceiver implements MessageListener {

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

	@Autowired
	MessageConverter messageConverter;

	public void onMessage(Message message) {
		try {
			String requetVoXml = (String) messageConverter.fromMessage(message);
			RequestVO requestVO = JaxbUnmarshaller.unmarshal(requetVoXml);
			String responseXml = ServiceExecutor.execute(requestVO.getRequest(), "http://localhost:8080/userserviceweb/rest/user/save");
			ServiceExecutor.postXml(responseXml, "http://localhost:8080/userserviceweb/rest/user/test");
			requestVO.setResponse(responseXml);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
