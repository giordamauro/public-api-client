package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.ApiProduct;
import com.util.ApiGeeUtil;

public class GetApiProductsForProxy {

	public static void main(String[] args) {

		final String organization = Org.LIVE_NATION;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Apigee";
		final String proxyName = "Member";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = publicApi.getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = publicApi.getApiProduct(apiProduct);
			List<String> proxies = apiProductInfo.getProxies();
			for (String proxy : proxies) {
				if (proxy.equalsIgnoreCase(proxyName)) {
					products.add(apiProductInfo.getName());
				}
			}

		}
		System.out.println(products);

	}

}
