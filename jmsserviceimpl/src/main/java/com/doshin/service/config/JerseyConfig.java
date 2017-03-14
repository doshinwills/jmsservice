package com.doshin.service.config;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		System.out.println("Doshin Loading filter");
		register(LoggingFilter.class);
	}
}
