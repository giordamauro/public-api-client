package com.apigee;

import com.http.proxy.ApiProxyFactory;

public class PublicAPI {

	private final ApigeeAPI apigeeAPI;

	public PublicAPI(ApiProxyFactory proxyFactory) {
		this.apigeeAPI = proxyFactory.getProxy(ApigeeAPI.class);
	}

	public ApigeeAPI getApigeeAPI() {
		return apigeeAPI;
	}
}
