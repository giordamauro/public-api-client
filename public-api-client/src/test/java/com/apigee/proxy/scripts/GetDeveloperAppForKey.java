package com.apigee.proxy.scripts;

import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.util.ApigeePublicApiTest;

public class GetDeveloperAppForKey extends ApigeePublicApiTest {

	private final String apiKey = "";

	@Test
	public void testGetDeveloperAppForKey() {

		String appName = getAppNameForApiKey(apiKey);

		System.out.println(appName);
	}

	private String getAppNameForApiKey(String apiKey) {

		List<String> apps = getPublicApi().getApps();

		for (String appName : apps) {
			DeveloperApp app = getPublicApi().getApp(appName);
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
