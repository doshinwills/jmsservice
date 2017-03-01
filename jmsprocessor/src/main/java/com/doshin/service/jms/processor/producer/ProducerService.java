package com.doshin.service.jms.processor.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("producerService")
public class ProducerService {
	@Autowired
	MessageSender messageSender;

	public void sendRequest(String payload) {
		messageSender.sendMessage(payload);
	}

}
