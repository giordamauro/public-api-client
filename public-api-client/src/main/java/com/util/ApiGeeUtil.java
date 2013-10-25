package com.util;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.apigee.ApigeeAPI;
import com.http.impl.httpclient.BasicAuthHttpFactory;
import com.http.model.HttpFactory;
import com.http.proxy.ApiMetadataHandler;
import com.http.proxy.ApiMethodHandler;
import com.http.proxy.ApiProxyFactory;
import com.http.proxy.ApiResultHandler;
import com.http.proxy.impl.ApiMetadataHandlerImpl;
import com.http.proxy.impl.ApiMethodHandlerImpl;
import com.http.proxy.impl.ApiResultHandlerImpl;
import com.http.tests.PublicApiPaths;

public final class ApiGeeUtil {

	public static final String API_GEE_HOST = "https://api.enterprise.apigee.com";

	public static final String BUNDLE_FORMAT = "bundle";

	private static final ApiMetadataHandler metadataHandler = new ApiMetadataHandlerImpl();

	private static final ApiResultHandler resultHandler = new ApiResultHandlerImpl();

	public static ApigeeAPI getPublicApi(String organization, String username, String password) {

		HttpClient defaultHttpClient = new DefaultHttpClient();

		HttpFactory httpFactory = new BasicAuthHttpFactory(defaultHttpClient, PublicApiPaths.API_GEE_HOST, username, password);
		httpFactory.setPathParam("organization", organization);

		ApiMethodHandler apiHandler = new ApiMethodHandlerImpl(metadataHandler, httpFactory, resultHandler);
		ApiProxyFactory proxyFactory = new ApiProxyFactory(apiHandler);

		ApigeeAPI publicApi = proxyFactory.getProxy(ApigeeAPI.class);

		return publicApi;
	}

	private ApiGeeUtil() {
	}

}
