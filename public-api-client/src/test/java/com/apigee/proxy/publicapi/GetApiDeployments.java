package com.apigee.proxy.publicapi;

import org.testng.annotations.Test;

import com.util.ApigeePublicApiTest;

public class GetApiDeployments extends ApigeePublicApiTest {

	private final String apiName = "wrapper-md5";

	@Test
	public void testGetApiDeployments() {

		String deployments = getPublicApi().getApiDeployments(apiName);

		System.out.println(deployments);

	}
}
