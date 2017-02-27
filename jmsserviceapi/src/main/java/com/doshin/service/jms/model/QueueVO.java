package com.doshin.service.jms.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "queue")
public class QueueVO {

	private Integer queueId;
	private String name;
	private String serviceUrl;
	private String callbackUrl;
	private Date createdOn;
	private Date updatedOn;

	List<RequestVO> requestList = new ArrayList<RequestVO>();

	public QueueVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QueueVO(Integer queueId, String name, String serviceUrl, String callbackUrl, Date createdOn, Date updatedOn,
			List<RequestVO> requestList) {
		super();
		this.queueId = queueId;
		this.name = name;
		this.serviceUrl = serviceUrl;
		this.callbackUrl = callbackUrl;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.requestList = requestList;
	}

	public Integer getQueueId() {
		return queueId;
	}

	public void setQueueId(Integer queueId) {
		this.queueId = queueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
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

	public List<RequestVO> getRequestList() {
		return requestList;
	}

	public void setRequestList(List<RequestVO> requestList) {
		this.requestList = requestList;
	}

	@Override
	public String toString() {
		return "QueueVO [queueId=" + queueId + ", name=" + name + ", serviceUrl=" + serviceUrl + ", callbackUrl="
				+ callbackUrl + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", requestList=" + requestList
				+ "]";
	}

}