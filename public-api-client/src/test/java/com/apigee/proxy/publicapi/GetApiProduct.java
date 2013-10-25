package com.apigee.proxy.publicapi;

import org.testng.annotations.Test;

import com.util.ApigeePublicApiTest;

public class GetApiProduct extends ApigeePublicApiTest {

	private final String apiProductName = "product_with_selected_resources";

	@Test
	public void testGetApiProduct() {

		getConfigurationManagamentAPI().getApiProduct(apiProductName);
	}
}
