package com.apigee.proxy.scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.apigee.model.Credential;
import com.apigee.model.DeveloperApp;
import com.apigee.model.DeveloperAppApiProduct;
import com.util.ApigeePublicApiTest;

public class GetAppsForApiProduct extends ApigeePublicApiTest {

	// private final List<String> apiProducts = Arrays.asList(new String[] {
	// "matt_test", "emailappend", "kcp", "Salesgenie", "apigeetestproduct",
	// "fedexqaa", "fedexservices", "whitespark", "salesgenie2",
	// "data_logix_unlimited" });

	private final List<String> apiProducts = Collections.singletonList("master");

	@Test
	public void testGetAppsForApiProduct() {

		Map<String, List<String>> apps = new HashMap<String, List<String>>();

		List<String> develperApps = getPublicApi().getApps();

		for (String app : develperApps) {
			DeveloperApp appInfo = getPublicApi().getApp(app);
			List<Credential> credentials = appInfo.getCredentials();
			for (Credential credential : credentials) {
				List<DeveloperAppApiProduct> developerApiProducts = credential.getApiProducts();
				for (DeveloperAppApiProduct apiProduct : developerApiProducts) {

					for (String product : apiProducts) {
						if (apiProduct.getApiproduct().equalsIgnoreCase(product)) {

							List<String> productApps = apps.get(product);
							if (productApps == null) {
								productApps = new ArrayList<String>();
							}
							productApps.add(appInfo.getName());
							apps.put(product, productApps);
						}
					}
				}
			}

		}
		System.out.println(apps);

	}
}
