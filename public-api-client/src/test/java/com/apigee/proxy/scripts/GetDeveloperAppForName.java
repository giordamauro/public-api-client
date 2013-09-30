package com.apigee.proxy.scripts;

import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.DeveloperApp;
import com.util.ApiGeeUtil;

public class GetDeveloperAppForName {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";
		final String appName = "NewBrokenApp";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		DeveloperApp app = getAppNameForName(publicApi, appName);

		System.out.println(app);
	}

	private static DeveloperApp getAppNameForName(ApigeeAPI publicApi, String name) {

		List<String> apps = publicApi.getApps();

		for (String appName : apps) {
			DeveloperApp app = publicApi.getApp(appName);
			if (app.getName().equalsIgnoreCase(name)) {
				return app;
			}
		}
		throw new IllegalStateException(String.format("Couldn't find app for name '%s'", name));
	}

}
