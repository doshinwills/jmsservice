package com.doshin.service.filter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(Exception exception) {
		exception.printStackTrace();
		return Response.status(500).build();
	}
}