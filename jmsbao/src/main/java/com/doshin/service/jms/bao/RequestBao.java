package com.doshin.service.jms.bao;

import com.doshin.service.jms.model.RequestVO;

public interface RequestBao {
	
	public RequestVO save(RequestVO request);
	public void update(RequestVO request);
	public void delete(RequestVO request);
	public RequestVO findByRequestId(Integer request);

}
