package com.doshin.service.jms.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

public class ServiceExecutor {

	public static String execute(String xml, String destUrl) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(destUrl);
		// create one todo

		Invocation.Builder invocationBuilder = service.request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		xml = invocationBuilder.post(Entity.entity(xml, MediaType.APPLICATION_XML), String.class);
		// Return code should be 201 == created resource
		return xml;
	}
	
	public static void postXml(String xml, String callBackUrl) {
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget service = client.target(callBackUrl);
		// create one todo

		Invocation.Builder invocationBuilder = service.request(MediaType.APPLICATION_XML);
		invocationBuilder.header(HttpHeaders.AUTHORIZATION, "Basic Z3dpbGxzOnBhc3M=");

		xml = invocationBuilder.post(Entity.entity(xml, MediaType.APPLICATION_XML), String.class);
		// Return code should be 201 == created resource
	}

}
