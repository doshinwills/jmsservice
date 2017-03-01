package com.doshin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.doshin.service.hibernate","com.doshin.service.jms.bao", 
	"com.doshin.service.jms.dao", "com.doshin.service.jms.processor.config",
	"com.doshin.service.jms.processor.producer"})
public class AppConfig{

}
