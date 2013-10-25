package com.apigee.model.configurationmanagement;

import java.util.List;

public class ApiRevisionDeployConfiguration {

	private String basePath;
	private List<String> steps;

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public List<String> getSteps() {
		return steps;
	}

	public void setSteps(List<String> steps) {
		this.steps = steps;
	}

}
