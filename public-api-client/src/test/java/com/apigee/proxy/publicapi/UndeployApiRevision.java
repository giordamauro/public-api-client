package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class UndeployApiRevision {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String environment = "test";
		final String apiName = "agero-resource-product";
		final int revision = 6;

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		String deploymentResult1 = publicApi.undeployApiProxyRevision(environment, apiName, revision);

		System.out.println(deploymentResult1);

	}
}
