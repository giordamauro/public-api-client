package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.apigee.model.ApiProduct;
import com.apigee.model.Attribute;
import com.util.ApigeePublicApiTest;

public class GetProdApiProducts extends ApigeePublicApiTest {

	@Test
	public void testGetProdApiProducts() {

		List<String> apiProductsProd = new ArrayList<String>();

		List<String> apiProducts = getPublicApi().getApiProducts();

		for (String apiProduct : apiProducts) {
			ApiProduct apiProd = getPublicApi().getApiProduct(apiProduct);
			List<Attribute> attributes = apiProd.getAttributes();
			for (Attribute att : attributes) {
				if (att.getName().equals("apisDeployedIn") && att.getValue().equals("prod")) {
					apiProductsProd.add(apiProduct);
				}
			}

		}
		System.out.println(apiProductsProd);

	}

}
