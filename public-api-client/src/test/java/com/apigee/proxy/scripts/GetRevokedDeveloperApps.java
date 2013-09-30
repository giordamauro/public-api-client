package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.util.ApiGeeUtil;

public class GetRevokedDeveloperApps {

	public static void main(String[] args) {

		final String organization = Org.INFOGROUP;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<DeveloperApp> revokedApps = new ArrayList<DeveloperApp>();

		List<String> apps = publicApi.getApps();

		for (String appName : apps) {
			DeveloperApp app = publicApi.getApp(appName);
			List<Credential> credentials = app.getCredentials();
			for (Credential credential : credentials) {
				if (credential.getStatus().equals("revoked")) {
					revokedApps.add(app);
				}
			}
		}

		System.out.println(revokedApps);
	}
}
