package com.apigee.model.configurationmanagement;

import java.util.List;

public class ApiRevisionDeployment {

	private ApiRevisionDeployConfiguration configuration;
	private String name;
	private List<DeploymentServer> server;
	private String state;

	public ApiRevisionDeployConfiguration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(ApiRevisionDeployConfiguration configuration) {
		this.configuration = configuration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DeploymentServer> getServer() {
		return server;
	}

	public void setServer(List<DeploymentServer> server) {
		this.server = server;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
