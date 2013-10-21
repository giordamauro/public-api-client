package com.apigee.proxy.scripts;

import org.testng.annotations.Test;

import com.util.ApigeePublicApiTest;

public class RevokeDeveloperAppKey extends ApigeePublicApiTest {

	private final String developer = "";
	private final String appName = "eomj_company_profile";
	private final String apiKey = "";

	@Test
	public void testRevokeDeveloperAppKey() {

		getPublicApi().editDeveloperAppKey(developer, appName, apiKey, "revoke");
	}

	@Test
	public void testApproveDeveloperAppKey() {

		getPublicApi().editDeveloperAppKey(developer, appName, apiKey, "approve");
	}
}
