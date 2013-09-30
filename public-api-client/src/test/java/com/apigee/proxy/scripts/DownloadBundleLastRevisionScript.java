package com.apigee.proxy.scripts;

import java.io.InputStream;

import com.apigee.ApigeeAPI;
import com.util.ApiGeeUtil;
import com.util.FileUtils;

public class DownloadBundleLastRevisionScript {

	public static void main(String[] args) {

		final String organization = "cvs";
		final String username = "mgiorda@apigee.com";
		final String password = "1234321Nomejodas";
		final String apiName = "loginapi";

		ApigeeAPI publicApi = ApiGeeUtil.getPublicApi(organization, username, password);

		InputStream bundle = publicApi.getApiBundle(apiName, 2, ApiGeeUtil.BUNDLE_FORMAT);

		FileUtils.streamToFile(bundle, apiName + ".zip");

	}

}
