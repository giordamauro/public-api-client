package com.apigee.proxy.publicapi;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import com.util.ApigeePublicApiTest;

public class UndeployApiRevision extends ApigeePublicApiTest {

	@Value("${environment.name}")
	private String environment;

	@Value("${api.name}")
	private String api;

	@Value("${revision.number}")
	private int revision;

	@Test
	public void testUndeployRevision() {

		String deploymentResult1 = getPublicApi().undeployApiProxyRevision(environment, api, revision);

		System.out.println(deploymentResult1);

	}
}
