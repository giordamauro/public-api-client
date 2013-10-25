package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.util.ApigeePublicApiTest;

public class GetApiProductsForProdEnvironment extends ApigeePublicApiTest {

	@Test
	public void testGetApiProductsForProdEnvironment() {

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = getConfigurationManagamentAPI().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = getConfigurationManagamentAPI().getApiProduct(apiProduct);
			List<String> environments = apiProductInfo.getEnvironments();
			if (environments.size() == 1 && environments.get(0).equals("prod")) {
				products.add(apiProduct);
			}

		}
		System.out.println(products);
	}

}
