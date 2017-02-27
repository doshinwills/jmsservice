package com.doshin.service.jms.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doshin.service.jms.model.RequestVO;

@Path("/request")
public interface RequestService {
	
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public RequestVO save(RequestVO request);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void update(RequestVO request);

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void delete(RequestVO request);

	@GET
	@Path("/findByRequestId/{requestid}")
	@Produces(MediaType.APPLICATION_XML)
	public RequestVO findByRequestId(@PathParam("requestid") Integer requestId);

}
