package com.apigee.proxy.publicapi;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.util.ApiGeeUtil;

public class GetApiProduct {

	public static void main(String[] args) {

		final String organization = Org.MGIORDA;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";
		final String apiProductName = "product_with_selected_resources";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		publicApi.getApiProduct(apiProductName);
	}
}
