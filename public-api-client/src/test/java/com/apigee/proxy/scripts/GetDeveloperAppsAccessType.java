package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.DeveloperApp;
import com.util.ApiGeeUtil;

public class GetDeveloperAppsAccessType {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<DeveloperApp> devApps = new ArrayList<DeveloperApp>();

		List<String> apps = publicApi.getApps();

		for (String appName : apps) {
			DeveloperApp app = publicApi.getApp(appName);
			if (!app.getAccessType().equals("")) {
				devApps.add(app);
			}
		}

		System.out.println(devApps);
	}
}
