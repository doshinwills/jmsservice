package com.doshin.service.jms.impl;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.doshin.service.jms.api.RequestService;
import com.doshin.service.jms.bao.RequestBao;
import com.doshin.service.jms.model.RequestVO;

@Path("/request")
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	RequestBao requestBao;

	@Override
	public RequestVO save(RequestVO request) {
		return requestBao.save(request);
	}

	@Override
	public void update(RequestVO request) {
		requestBao.update(request);
	}

	@Override
	public void delete(RequestVO request) {
		requestBao.delete(request);;
	}

	@Override
	public RequestVO findByRequestId(Integer requestId) {
		return requestBao.findByRequestId(requestId);
	}

}