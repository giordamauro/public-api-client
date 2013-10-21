package com.apigee.proxy.scripts;

import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.DeveloperApp;
import com.util.ApigeePublicApiTest;

public class GetDeveloperAppForName extends ApigeePublicApiTest {

	private final String appName = "";

	@Test
	public void testGetDeveloperAppForName() {

		DeveloperApp app = getAppNameForName(appName);

		System.out.println(app);
	}

	private DeveloperApp getAppNameForName(String name) {

		List<String> apps = getPublicApi().getApps();

		for (String appName : apps) {
			DeveloperApp app = getPublicApi().getApp(appName);
			if (app.getName().equalsIgnoreCase(name)) {
				return app;
			}
		}
		throw new IllegalStateException(String.format("Couldn't find app for name '%s'", name));
	}

}
