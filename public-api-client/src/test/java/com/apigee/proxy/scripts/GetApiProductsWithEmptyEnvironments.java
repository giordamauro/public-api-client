package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.util.ApigeePublicApiTest;

public class GetApiProductsWithEmptyEnvironments extends ApigeePublicApiTest {

	@Test
	public void testGetApiProductsWithEmptyEnvironments() {

		List<String> products = new ArrayList<String>();

		List<String> apiProducts = getPublicApi().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = getPublicApi().getApiProduct(apiProduct);
			List<String> environments = apiProductInfo.getEnvironments();
			if (environments.size() == 0) {
				products.add(apiProduct);
			}

		}
		System.out.println(products);

	}

}
