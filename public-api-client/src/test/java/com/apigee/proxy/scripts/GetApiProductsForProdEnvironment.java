package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import com.apigee.ApigeeAPI;
import com.apigee.Dev;
import com.apigee.Org;
import com.apigee.model.ApiProduct;
import com.util.ApiGeeUtil;

public class GetApiProductsForProdEnvironment {

	public static void main(String[] args) {

		final String organization = Org.INFOGROUP;
		final String username = Dev.MGIORDA_APIGEE;
		final String password = "1234321Nomejodas";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = publicApi.getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = publicApi.getApiProduct(apiProduct);
			List<String> environments = apiProductInfo.getEnvironments();
			if (environments.size() == 1 && environments.get(0).equals("prod")) {
				products.add(apiProduct);
			}

		}
		System.out.println(products);

	}

}
