package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

import com.apigee.model.configurationmanagement.ApiProxyDeployment;
import com.apigee.model.configurationmanagement.ApiRevisionDeployment;
import com.apigee.model.configurationmanagement.EnvironmentDeployments;
import com.util.ApigeePublicApiTest;

public class GetDeployedRevisionsForEnvironment extends ApigeePublicApiTest {

	@Value("${environment.name}")
	private String environment;

	@Test
	public void testGetDeployedRevisionsForEnvironment() {

		Map<String, List<String>> deployedRevisionsResult = new HashMap<String, List<String>>();

		EnvironmentDeployments deployments = getConfigurationManagamentAPI().getEnvironmentDeployments(environment);
		List<ApiProxyDeployment> aPIProxies = deployments.getaPIProxy();

		for (ApiProxyDeployment proxy : aPIProxies) {
			String proxyName = proxy.getName();

			List<String> revisions = new ArrayList<String>();

			List<ApiRevisionDeployment> proxyRevisions = proxy.getRevision();

			for (ApiRevisionDeployment revision : proxyRevisions) {
				revisions.add(revision.getName());
			}
			deployedRevisionsResult.put(proxyName, revisions);
		}
		System.out.println(deployedRevisionsResult);
	}
}
