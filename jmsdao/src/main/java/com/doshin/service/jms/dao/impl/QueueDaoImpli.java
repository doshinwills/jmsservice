package com.doshin.service.jms.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doshin.service.jms.dao.QueueDao;
import com.doshin.service.jms.dao.model.QueueDO;

@Repository("queueDao")
public class QueueDaoImpli implements QueueDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public QueueDO save(QueueDO queue) {
		getSession().saveOrUpdate(queue);
		return queue;
	}

	public void update(QueueDO ptsQueue) {
		getSession().update(ptsQueue);
	}

	public void delete(QueueDO ptsQueue) {
		getSession().delete(ptsQueue);
	}

	public QueueDO findByQueueId(Integer QueueId) {
		Criteria criteria = getSession().createCriteria(QueueDO.class);
		criteria.add(Restrictions.eq("queueId", QueueId));
		return (QueueDO) criteria.uniqueResult();
	}

}
