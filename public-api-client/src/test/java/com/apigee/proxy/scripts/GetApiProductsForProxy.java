package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.util.ApigeePublicApiTest;

public class GetApiProductsForProxy extends ApigeePublicApiTest {

	private final String proxyName = "Member";

	@Test
	public void testGetApiProductsForProxy() {

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = getConfigurationManagamentAPI().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = getConfigurationManagamentAPI().getApiProduct(apiProduct);
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
