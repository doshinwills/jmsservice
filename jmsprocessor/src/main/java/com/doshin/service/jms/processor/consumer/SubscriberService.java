package com.doshin.service.jms.processor.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.doshin.service.jms.model.QueueVO;
import com.doshin.service.jms.model.RequestVO;
import com.doshin.service.jms.processor.callback.ResponseCallback;
import com.doshin.service.jms.util.JaxbUnmarshaller;
import com.doshin.service.jms.util.ServiceExecutor;

@Component
public class SubscriberService implements MessageListener {

	static final Logger LOG = LoggerFactory.getLogger(SubscriberService.class);

	@Autowired
	MessageConverter messageConverter;

	@Autowired
	ResponseCallback responseCallback;

	public void onMessage(Message message) {
		RequestVO requestVO = null;
		try {
			String requetVoXml = (String) messageConverter.fromMessage(message);
			requestVO = JaxbUnmarshaller.unmarshal(requetVoXml);
			requestVO = responseCallback.sendRequest(requestVO);
			QueueVO queueVO = requestVO.getQueue();
			String responseXml = ServiceExecutor.execute(requestVO.getRequest(), queueVO.getServiceUrl());
			requestVO.setResponse(responseXml);
			requestVO = responseCallback.recivedResponse(requestVO);
			ServiceExecutor.postXml(responseXml, queueVO.getCallbackUrl());
			requestVO = responseCallback.responsed(requestVO);
		} catch (Exception e) {
			LOG.error("Failure", e);
			requestVO = responseCallback.requestFailed(requestVO);
		}

	}
}
