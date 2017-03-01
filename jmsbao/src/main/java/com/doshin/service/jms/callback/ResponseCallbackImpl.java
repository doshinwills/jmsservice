package com.doshin.service.jms.callback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doshin.service.jms.bao.QueueBao;
import com.doshin.service.jms.bao.RequestBao;
import com.doshin.service.jms.model.QueueVO;
import com.doshin.service.jms.model.RequestVO;
import com.doshin.service.jms.processor.callback.ResponseCallback;

@Service
public class ResponseCallbackImpl implements ResponseCallback {

	@Autowired
	RequestBao requestBao;

	@Autowired
	QueueBao queueBao;

	@Override
	public RequestVO enquededRequest(RequestVO requestVO) {
		requestVO = requestBao.findByRequestId(requestVO.getRequestId());
		requestVO.getStatus().setStatusId(2);
		requestBao.update(requestVO);
		return requestVO;
	}

	@Override
	public RequestVO sendRequest(RequestVO requestVO) {
		requestVO = requestBao.findByRequestId(requestVO.getRequestId());
		requestVO.getStatus().setStatusId(3);
		requestBao.update(requestVO);
		return requestVO;

	}
	
	@Override
	public QueueVO getQueue(Integer queueId) {
		return queueBao.findByQueueId(queueId);
	}

	@Override
	public RequestVO recivedResponse(RequestVO requestVO) {
		RequestVO requestFromDb = requestBao.findByRequestId(requestVO.getRequestId());
		requestFromDb.getStatus().setStatusId(4);
		requestFromDb.setResponse(requestVO.getResponse());
		requestBao.update(requestFromDb);
		return requestFromDb;
	}

	@Override
	public RequestVO requestFailed(RequestVO requestVO) {
		requestVO = requestBao.findByRequestId(requestVO.getRequestId());
		requestVO.getStatus().setStatusId(5);
		requestBao.update(requestVO);
		return requestVO;
	}

	@Override
	public RequestVO responsed(RequestVO requestVO) {
		requestVO = requestBao.findByRequestId(requestVO.getRequestId());
		requestVO.getStatus().setStatusId(6);
		requestBao.update(requestVO);
		return requestVO;
	}

}
