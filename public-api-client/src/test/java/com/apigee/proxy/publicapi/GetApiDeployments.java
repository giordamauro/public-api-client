package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class GetApiDeployments {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String apiName = "wrapper-md5";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		String deployments = publicApi.getApiDeployments(apiName);

		System.out.println(deployments);

	}
}
