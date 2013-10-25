package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.util.ApigeePublicApiTest;

public class GetApiProductForResourcePath extends ApigeePublicApiTest {

	private final List<String> resourcePaths = Arrays.asList(new String[] { "/\\*\\*", "/\\*\\*\\*", ".*\\*\\*\\*.*", ".*\\*\\*\\*\\*.*" });

	@Test
	public void testGetApiProductForResourcePath() {

		Map<String, List<String>> apiProductsResult = new HashMap<String, List<String>>();

		List<String> apiProducts = getConfigurationManagamentAPI().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProductInfo = getConfigurationManagamentAPI().getApiProduct(apiProduct);
			List<String> resources = apiProductInfo.getApiResources();
			for (String resource : resources) {
				for (String resourcePath : resourcePaths) {
					if (resource.matches(resourcePath)) {

						List<String> productApps = apiProductsResult.get(resourcePath);
						if (productApps == null) {
							productApps = new ArrayList<String>();
						}
						productApps.add(apiProductInfo.getName());
						apiProductsResult.put(resourcePath, productApps);
					}
				}
			}

		}
		System.out.println(apiProductsResult);
	}
}
