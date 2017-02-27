package com.doshin.service.jms.dao;

import com.doshin.service.jms.dao.model.RequestDO;

public interface RequestDao {

	public RequestDO save(RequestDO request);
	public void update(RequestDO request);
	public void delete(RequestDO request);
	public RequestDO findByRequestId(Integer request);

}
