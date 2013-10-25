package com.http.proxy.impl;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.http.model.FormRequest;
import com.http.model.HttpFactory;
import com.http.model.HttpMethod;
import com.http.model.HttpRequest;
import com.http.model.QueryRequest;
import com.http.model.RawPayload;
import com.http.model.RequestParams;
import com.http.proxy.ApiMetadataHandler;
import com.http.proxy.ApiMethodHandler;
import com.http.proxy.BaseServiceMetadata;

public class CurlApiMethodHandlerImpl implements ApiMethodHandler {

	private Log logger = LogFactory.getLog(getClass());

	private final ApiMetadataHandler metadataHandler;

	private final HttpFactory requestFactory;

	public CurlApiMethodHandlerImpl(ApiMetadataHandler metadataHandler, HttpFactory requestFactory) {

		if (metadataHandler == null || requestFactory == null) {

			throw new IllegalArgumentException("MetadataHandler and requestFactory cannot be null");
		}
		this.metadataHandler = metadataHandler;
		this.requestFactory = requestFactory;
	}

	public Object handleMethodCall(Method method, Object[] args) throws Exception {

		if (!method.getDeclaringClass().equals(Object.class)) {

			logger.info(String.format("Invoking service method: '%s.%s(%s)'", method.getDeclaringClass().getSimpleName(), method.getName(), getMethodTypesLog(method.getParameterTypes())));

			BaseServiceMetadata metadata = metadataHandler.getBaseServiceMetadata(method);
			Map<String, String> pathParams = metadataHandler.getPathParams(method, args);

			HttpRequest request = requestFactory.newRequest(metadata.getMethod(), metadata.getUrl());
			request.setPathParams(pathParams);

			if (metadata.getMethod() != HttpMethod.OPTIONS) {
				RequestParams queryParams = metadataHandler.getQueryParams(method, args);
				QueryRequest queryRequest = (QueryRequest) request;
				queryRequest.addQueryParams(queryParams);
			}

			// TODO incorporar otros tipos de Payload!
			if ((metadata.getMethod() == HttpMethod.POST || metadata.getMethod() == HttpMethod.PUT) && metadata.getConsumes().contains("application/json")) {
				if (args.length == 1) {
					String json = null;
					Object argument = args[0];
					if (argument.getClass().isAssignableFrom(String.class)) {
						json = String.valueOf(argument);
					} else {
						json = new Gson().toJson(argument);
					}

					FormRequest formRequest = (FormRequest) request;
					formRequest.setPayload(RawPayload.JSON(json));
				} else {
					throw new IllegalStateException("Json payload request cannot be called with multiple parameters");
				}
			}

			request.send();

			return null;
		} else {
			return method.invoke(this, args);
		}
	}

	private String getMethodTypesLog(Class<?>[] parameterTypes) {

		String types = "";

		for (Class<?> parameterClass : parameterTypes) {

			types += parameterClass.getSimpleName() + ", ";
		}
		if (parameterTypes.length > 0) {
			types = types.substring(0, types.length() - 2);
		}
		return types;
	}
}
