package com.apigee.proxy.publicapi;

import com.util.ApigeePublicApiTest;

public class GetDeveloperAppByDeveloper extends ApigeePublicApiTest {

	private final String appName = "MyTestApp";
	private final String developer = "schumann@infogroup.com";

	public void main(String[] args) {

		getPublicApi().getDeveloperApp(developer, appName);
	}
}
