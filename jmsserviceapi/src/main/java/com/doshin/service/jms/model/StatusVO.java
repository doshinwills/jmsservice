package com.doshin.service.jms.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "status")
public class StatusVO {

	private Integer statusId;
	private String name;

	public StatusVO() {
		super();
	}

	public StatusVO(Integer statusId, String name) {
		super();
		this.statusId = statusId;
		this.name = name;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "StatusVO [statusId=" + statusId + ", name=" + name + "]";
	}

}
