package com.doshin.service.jms.impl;

import java.util.Date;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.doshin.service.jms.api.QueueService;
import com.doshin.service.jms.bao.QueueBao;
import com.doshin.service.jms.model.QueueVO;

@Path("/queue")
public class QueueServiceImpl implements QueueService{
	
	@Autowired
	QueueBao queueBao;

	@Override
	public QueueVO save(QueueVO queue) {
		return queueBao.save(queue);
	}

	@Override
	public void update(QueueVO queue) {
		queueBao.update(queue);
	}

	@Override
	public void delete(QueueVO queue) {
		queueBao.delete(queue);;
	}

	@Override
	public QueueVO findByQueueId(Integer queueId) {
		return queueBao.findByQueueId(queueId);
	}

}