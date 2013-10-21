package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.DeveloperApp;
import com.util.ApigeePublicApiTest;

public class GetDeveloperAppsAccessType extends ApigeePublicApiTest {

	@Test
	public void testGetDeveloperAppsAccessType() {

		List<DeveloperApp> devApps = new ArrayList<DeveloperApp>();

		List<String> apps = getPublicApi().getApps();

		for (String appName : apps) {
			DeveloperApp app = getPublicApi().getApp(appName);
			if (!app.getAccessType().equals("")) {
				devApps.add(app);
			}
		}

		System.out.println(devApps);
	}
}
