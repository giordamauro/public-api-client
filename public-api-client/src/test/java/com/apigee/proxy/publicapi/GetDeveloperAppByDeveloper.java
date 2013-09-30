package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class GetDeveloperAppByDeveloper {

	public static void main(String[] args) {

		final String organization = Org.INFOGROUP;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String appName = "MyTestApp";
		final String developer = "schumann@infogroup.com";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		publicApi.getDeveloperApp(developer, appName);
	}
}
