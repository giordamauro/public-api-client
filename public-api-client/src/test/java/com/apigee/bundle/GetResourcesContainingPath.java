package com.apigee.bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bundle.model.Bundle;
import com.bundle.model.Flow;
import com.bundle.model.ProxyEndpoint;

public class GetResourcesContainingPath {

	public static void main(String[] args) {

		final String path = "/identity";

		List<String> resources = new ArrayList<String>();

		Bundle bundle = Bundle.loadFromZip("api-proxy.zip");

		Map<String, ProxyEndpoint> proxies = bundle.getProxies();
		for (ProxyEndpoint proxy : proxies.values()) {

			List<Flow> flows = proxy.getFlows();
			for (Flow flow : flows) {
				String condition = flow.getCondition();
				if (condition != null && condition.contains(path)) {
					resources.add(flow.getName());
				}
			}
		}

		System.out.println(resources);
	}

}
