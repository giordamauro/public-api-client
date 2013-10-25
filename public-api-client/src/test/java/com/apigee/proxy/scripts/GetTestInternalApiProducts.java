package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.apigee.model.Attribute;
import com.util.ApigeePublicApiTest;

public class GetTestInternalApiProducts extends ApigeePublicApiTest {

	@Test
	public void testGetProdApiProducts() {

		List<String> apiProductsProd = new ArrayList<String>();

		List<String> apiProducts = getConfigurationManagamentAPI().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProd = getConfigurationManagamentAPI().getApiProduct(apiProduct);
			if (apiProd.getEnvironments().contains("test")) {
				List<Attribute> attributes = apiProd.getAttributes();
				for (Attribute att : attributes) {
					if (att.getName().equals("access") && !att.getValue().equals("internal")) {
						apiProductsProd.add(apiProduct);
					}
				}
			}
		}
		System.out.println(apiProductsProd);

	}

}
