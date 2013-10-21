package com.apigee.proxy.publicapi;

import org.testng.annotations.Test;

import com.util.ApigeePublicApiTest;

public class DeployApiRevision extends ApigeePublicApiTest {

	private final String apiName = "agero-resource-product";
	private final int revision = 6;
	private final String environment = "prod";

	@Test
	public void testDeployApiRevision() {

		String deploymentResult1 = getPublicApi().deployApiProxyRevision(apiName, revision, "deploy", environment);

		System.out.println(deploymentResult1);
	}
}
