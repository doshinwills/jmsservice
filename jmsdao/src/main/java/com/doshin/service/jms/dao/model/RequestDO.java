package com.doshin.service.jms.dao.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "request", schema = "public")
public class RequestDO {

	@Id
	@Column(name = "requestid")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Integer requestId;

	@Column(name = "refid")
	private String refId;

	@Column(name = "requestcontent")
	private String requestContent;

	@Column(name = "request")
	private String request;

	@Column(name = "response")
	private String response;

	@Column(name = "createdon")
	private Date createdOn;

	@Column(name = "updatedon")
	private Date updatedOn;

	@ManyToOne
	@JoinColumn(name = "queueid")
	private QueueDO queue;

	@OneToOne
	@JoinTable(name = "requeststatus", joinColumns = @JoinColumn(name = "requestid") , inverseJoinColumns = @JoinColumn(name = "statusid") )
	private StatusDO status;

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

	public QueueDO getQueue() {
		return queue;
	}

	public void setQueue(QueueDO queue) {
		this.queue = queue;
	}

	public StatusDO getStatus() {
		return status;
	}

	public void setStatus(StatusDO status) {
		this.status = status;
	}


}
