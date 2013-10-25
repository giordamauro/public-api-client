package com.apigee.model.configurationmanagement;

import java.util.List;

public class DeploymentServer {

	private String status;
	private List<String> type;
	private String uUID;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public String getuUID() {
		return uUID;
	}

	public void setuUID(String uUID) {
		this.uUID = uUID;
	}
}
