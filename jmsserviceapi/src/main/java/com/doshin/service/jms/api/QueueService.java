package com.doshin.service.jms.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doshin.service.jms.model.QueueVO;

@Path("/queue")
public interface QueueService {
	
	
	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public QueueVO save(QueueVO queue);

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void update(QueueVO queue);

	@POST
	@Path("/delete")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public void delete(QueueVO queue);

	@GET
	@Path("/findByQueueId/{queueid}")
	@Produces(MediaType.APPLICATION_XML)
	public QueueVO findByQueueId(@PathParam("queueid") Integer queueId);

}
