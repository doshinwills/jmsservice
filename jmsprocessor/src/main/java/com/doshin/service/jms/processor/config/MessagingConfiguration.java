package com.doshin.service.jms.processor.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import com.doshin.service.jms.processor.consumer.SubscriberService;

@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class MessagingConfiguration {

	@Autowired
	private Environment environment;

	private static final String ORDER_QUEUE = "order-queue";
	
	@Autowired
	SubscriberService subscriberService;

	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(environment.getRequiredProperty("jms.brokerurl"));
		return connectionFactory;
	}

	@Bean
	public ConnectionFactory cachingConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setTargetConnectionFactory(connectionFactory());
		connectionFactory.setSessionCacheSize(10);
		return connectionFactory;
	}

	/*
	 * Used here for Sending Messages.
	 */
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(ORDER_QUEUE);
		return template;
	}
	
	/*
	 * Message listener container, used for invoking messageReceiver.onMessage on message reception.
	 */
	@Bean
	public MessageListenerContainer getContainer(){
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(ORDER_QUEUE);
		container.setMessageListener(subscriberService);
		return container;
	}

	
	
	@Bean 
	MessageConverter converter(){
		return new SimpleMessageConverter();
	}

}
