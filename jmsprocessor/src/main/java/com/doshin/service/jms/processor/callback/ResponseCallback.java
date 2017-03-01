package com.doshin.service.jms.processor.callback;

import com.doshin.service.jms.model.QueueVO;
import com.doshin.service.jms.model.RequestVO;

public interface ResponseCallback {
	RequestVO enquededRequest(RequestVO requestVO);
	RequestVO sendRequest(RequestVO requestVO);
	RequestVO recivedResponse(RequestVO requestVO);
	RequestVO requestFailed(RequestVO requestVO);
	RequestVO responsed(RequestVO requestVO);
	QueueVO getQueue(Integer queueId);


}
