package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.util.ApigeePublicApiTest;

public class GetApiProductsWithEmptyProxies extends ApigeePublicApiTest {

	@Test
	public void testGetApiProductsWithEmptyProxies() {

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = getConfigurationManagamentAPI().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = getConfigurationManagamentAPI().getApiProduct(apiProduct);
			List<String> proxies = apiProductInfo.getProxies();
			if (proxies.size() == 0) {
				products.add(apiProduct);
			}

		}
		System.out.println(products);

	}

}
