package com.doshin.service.jms.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doshin.service.jms.dao.RequestDao;
import com.doshin.service.jms.dao.model.QueueDO;
import com.doshin.service.jms.dao.model.RequestDO;

@Repository("requestDao")
public class RequestDaoImpli implements RequestDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public RequestDO save(RequestDO request) {
		getSession().saveOrUpdate(request);
		return request;
	}

	@Override
	public void update(RequestDO request) {
		getSession().update(request);
	}

	@Override
	public void delete(RequestDO request) {
		getSession().delete(request);

	}

	@Override
	public RequestDO findByRequestId(Integer request) {
		Criteria criteria = getSession().createCriteria(RequestDO.class);
		criteria.add(Restrictions.eq("requestId", request));
		return (RequestDO) criteria.uniqueResult();
	}

}
