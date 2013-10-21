package com.apigee.proxy.publicapi;

import com.util.ApigeePublicApiTest;

public class GetApiRevisionDeployments extends ApigeePublicApiTest {

	private final String apiName = "wrapper-md5";
	private final int revision = 1;

	public void testGetApiRevisionDeployments() {

		String deployments = getPublicApi().getApiRevisionDeployments(apiName, revision);

		System.out.println(deployments);

	}
}
