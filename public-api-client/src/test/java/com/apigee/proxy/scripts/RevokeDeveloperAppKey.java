package com.apigee.proxy.scripts;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class RevokeDeveloperAppKey {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		final String appName = "eomj_company_profile";
		final String apiKey = "HDMadGLRwPYSAuce7sp5slGGGzK3hOCR";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		publicApi.editDeveloperAppKey("tjackson@monster.com", appName, apiKey, "approve");
	}
}
