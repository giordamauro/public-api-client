package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class DeployApiRevision {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String apiName = "wrapper-md5";
		final int revision = 4;
		final String environment = "test";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		String deploymentResult1 = publicApi.deployApiProxyRevision(apiName, revision, "undeploy", environment);

		System.out.println(deploymentResult1);

		// String deploymentResult = publicApi.deployApiProxyRevision(apiName,
		// 5, "deploy", environment);
		//
		// System.out.println(deploymentResult);

	}
}
