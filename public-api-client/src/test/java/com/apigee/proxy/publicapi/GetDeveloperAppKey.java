package com.apigee.proxy.publicapi;

import com.util.ApigeePublicApiTest;

public class GetDeveloperAppKey extends ApigeePublicApiTest {

	private final String developer = "mgiorda@devspark.com";
	private final String appName = "Broken";
	private final String key = "NUseG5q1Ayj2cUWqV8gWTtB9oJjTAsjc";

	public void testGetDeveloperAppKey() {

		getPublicApi().getDeveloperAppKey(developer, appName, key);
	}
}
