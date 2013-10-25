package com.apigee.proxy.publicapi;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.util.ApigeePublicApiTest;

public class CreateApiProduct extends ApigeePublicApiTest {

	private final String apiProductName = "myName";

	@Test
	public void testDeployApiRevision() {

		ApiProduct apiProduct = getConfigurationManagamentAPI().getApiProduct(apiProductName);

		apiProduct.setName(apiProductName + "7");

		getConfigurationManagamentAPI().createApiProduct(apiProduct);
	}
}
