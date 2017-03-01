package com.doshin.service.jms.processor.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doshin.service.jms.model.RequestVO;
import com.doshin.service.jms.processor.callback.ResponseCallback;
import com.doshin.service.jms.util.JaxbUnmarshaller;

@Service("producerService")
public class ProducerService {
	@Autowired
	MessageSender messageSender;

	@Autowired
	ResponseCallback responseCallback;

	public void sendRequest(String payload) {
		messageSender.sendMessage(payload);
		RequestVO requestVO = JaxbUnmarshaller.unmarshal(payload);
		responseCallback.enquededRequest(requestVO);
	}

}
