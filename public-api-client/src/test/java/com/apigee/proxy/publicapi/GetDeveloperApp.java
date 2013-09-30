package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class GetDeveloperApp {

	public static void main(String[] args) {

		final String organization = Org.INFOGROUP;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";
		final String appName = "4866ea87-6db2-4772-9b0c-6db480eccba9";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		publicApi.getApp(appName);
	}
}
