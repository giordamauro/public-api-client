package com.apigee.proxy.scripts;

import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.util.ApiGeeUtil;

public class GetDeveloperAppForKey {

	public static void main(String[] args) {

		final String organization = Org.INFOGROUP;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";
		final String apiKey = "HDMadGLRwPYSAuce7sp5slGGGzK3hOCR";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		String appName = getAppNameForApiKey(publicApi, apiKey);

		System.out.println(appName);
	}

	private static String getAppNameForApiKey(ApigeeAPI publicApi, String apiKey) {

		List<String> apps = publicApi.getApps();

		for (String appName : apps) {
			DeveloperApp app = publicApi.getApp(appName);
			List<Credential> credentials = app.getCredentials();
			for (Credential credential : credentials) {
				if (credential.getConsumerKey().equals(apiKey)) {
					return app.getName();

				}
			}
		}
		throw new IllegalStateException(String.format("Couldn't find app for key '%s'", apiKey));
	}

}
