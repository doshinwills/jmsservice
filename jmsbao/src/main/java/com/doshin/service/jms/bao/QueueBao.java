package com.doshin.service.jms.bao;

import com.doshin.service.jms.model.QueueVO;

public interface QueueBao {
	
	public QueueVO save(QueueVO queue);
	public void update(QueueVO queue);
	public void delete(QueueVO queue);
	public QueueVO findByQueueId(Integer queueId);

}
