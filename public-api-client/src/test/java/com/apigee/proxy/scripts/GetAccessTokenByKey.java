package com.apigee.proxy.scripts;

import org.testng.annotations.Test;

import com.apigee.model.AccessToken;
import com.util.ApigeePublicApiTest;

public class GetAccessTokenByKey extends ApigeePublicApiTest {

	private final String accessToken = "ZkKAkbgAztZ93xS4kuDMryVPaVKU";

	@Test
	public void testGetAccessTokenByKey() {

		AccessToken info = getPublicApi().getAccessToken(accessToken);

		System.out.println(info.getStatus());
	}
}