package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class GetDeveloperAppKey {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String developer = "mgiorda@devspark.com";
		final String appName = "Broken";
		final String key = "NUseG5q1Ayj2cUWqV8gWTtB9oJjTAsjc";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		publicApi.getDeveloperAppKey(developer, appName, key);
	}
}
