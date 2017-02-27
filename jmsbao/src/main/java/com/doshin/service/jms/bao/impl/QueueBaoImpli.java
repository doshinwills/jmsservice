package com.doshin.service.jms.bao.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doshin.service.jms.bao.QueueBao;
import com.doshin.service.jms.dao.QueueDao;
import com.doshin.service.jms.dao.model.QueueDO;
import com.doshin.service.jms.model.QueueVO;

@Service("queueBao")
@Transactional
public class QueueBaoImpli implements QueueBao {

	@Autowired
	QueueDao queueDao;
	
	@Override
	public QueueVO save(QueueVO queueBo) {
		QueueDO queueDO = new QueueDO();
		BeanUtils.copyProperties(queueBo, queueDO);
		queueDO = queueDao.save(queueDO);
		queueBo = new QueueVO();
		BeanUtils.copyProperties(queueDO, queueBo);
		return queueBo;
	}

	@Override
	public void update(QueueVO queueBo) {
		QueueDO queueDO = new QueueDO();
		BeanUtils.copyProperties(queueBo, queueDO);
		queueDao.update(queueDO);
	}

	@Override
	public void delete(QueueVO queueBo) {
		QueueDO queueDO = new QueueDO();
		BeanUtils.copyProperties(queueBo, queueDO);
		queueDao.delete(queueDO);
	}

	@Override
	public QueueVO findByQueueId(Integer queueId) {
		QueueDO queueDO = queueDao.findByQueueId(queueId);
		QueueVO queueVo = new QueueVO();
		BeanUtils.copyProperties(queueDO, queueVo);
		return queueVo;
	}

	

}
