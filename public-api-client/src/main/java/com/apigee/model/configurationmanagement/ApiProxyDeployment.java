package com.apigee.model.configurationmanagement;

import java.util.List;

public class ApiProxyDeployment {

	private String name;

	private List<ApiRevisionDeployment> revision;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ApiRevisionDeployment> getRevision() {
		return revision;
	}

	public void setRevision(List<ApiRevisionDeployment> revision) {
		this.revision = revision;
	}
}
