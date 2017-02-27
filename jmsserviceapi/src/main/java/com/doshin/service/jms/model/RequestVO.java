package com.doshin.service.jms.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "request")
public class RequestVO {

	private Integer requestId;
	private String refId;
	private String requestContent;
	private String request;
	private String response;
	private Date createdOn;
	private Date updatedOn;

	StatusVO status;

	QueueVO queue;

	public RequestVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestVO(Integer requestId, String refId, String requestContent, String request, String response,
			Date createdOn, Date updatedOn, StatusVO status, QueueVO queue) {
		super();
		this.requestId = requestId;
		this.refId = refId;
		this.requestContent = requestContent;
		this.request = request;
		this.response = response;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.status = status;
		this.queue = queue;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getRequestContent() {
		return requestContent;
	}

	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public StatusVO getStatus() {
		return status;
	}

	public void setStatus(StatusVO status) {
		this.status = status;
	}

	public QueueVO getQueue() {
		return queue;
	}

	public void setQueue(QueueVO queue) {
		this.queue = queue;
	}

	@Override
	public String toString() {
		return "RequestVO [requestId=" + requestId + ", refId=" + refId + ", requestContent=" + requestContent
				+ ", request=" + request + ", response=" + response + ", createdon=" + createdOn + ", updatedon="
				+ updatedOn + ", status=" + status + ", queue=" + queue + "]";
	}

}
