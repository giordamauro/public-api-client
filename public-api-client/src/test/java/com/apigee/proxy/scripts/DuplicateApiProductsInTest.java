package com.apigee.proxy.scripts;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.apigee.model.Attribute;
import com.util.ApigeePublicApiTest;

public class DuplicateApiProductsInTest extends ApigeePublicApiTest {

	@Test
	public void testDeployApiRevision() {

		List<String> apiProducts = getConfigurationManagamentAPI().getApiProducts();

		for (String apiProductName : apiProducts) {

			ApiProduct apiProduct = getConfigurationManagamentAPI().getApiProduct(apiProductName);

			String newApiProductName = apiProductName + "-test";
			if (!apiProductIsDeployedInTest(apiProduct) && !existsApiProduct(newApiProductName, apiProducts)) {

				apiProduct.setName(newApiProductName);
				apiProduct.setAttributes(Collections.<Attribute> emptyList());
				apiProduct.setDisplayName(apiProduct.getDisplayName() + " Test");
				apiProduct.setEnvironments(Collections.singletonList("test"));

				getConfigurationManagamentAPI().createApiProduct(apiProduct);
			}
		}

	}

	private boolean apiProductIsDeployedInTest(ApiProduct apiProduct) {
		List<String> environments = apiProduct.getEnvironments();
		for (String environment : environments) {
			if (environment.equals("test")) {
				return true;
			}
		}
		return false;
	}

	private boolean existsApiProduct(String newApiProductName, List<String> apiProducts) {
		for (String apiProduct : apiProducts) {
			if (apiProduct.equals(newApiProductName)) {
				return true;
			}
		}
		return false;
	}
}
