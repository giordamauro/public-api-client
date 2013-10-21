package com.apigee.proxy.publicapi;

import com.util.ApigeePublicApiTest;

public class GetDeveloperApp extends ApigeePublicApiTest {

	private final String appName = "4866ea87-6db2-4772-9b0c-6db480eccba9";

	public void testGetDeveloperApp() {

		getPublicApi().getApp(appName);
	}
}
