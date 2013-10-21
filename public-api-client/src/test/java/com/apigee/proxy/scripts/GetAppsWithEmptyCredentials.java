package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.util.ApigeePublicApiTest;

public class GetAppsWithEmptyCredentials extends ApigeePublicApiTest {

	@Test
	public void testTestApiProxy() {

		List<String> appNames = getEmptyCredentialsApps();

		System.out.println(appNames);
		System.out.println(appNames.size());
	}

	private List<String> getEmptyCredentialsApps() {

		List<String> emptyApps = new ArrayList<String>();

		List<String> apps = getPublicApi().getApps();

		for (String appName : apps) {
			DeveloperApp app = getPublicApi().getApp(appName);
			List<Credential> credentials = app.getCredentials();
			if (credentials.isEmpty()) {
				emptyApps.add(appName);
			}

		}
		return emptyApps;
	}

}
