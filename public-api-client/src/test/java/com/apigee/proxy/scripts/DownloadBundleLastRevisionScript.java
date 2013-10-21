package com.apigee.proxy.scripts;

import java.io.InputStream;

import org.testng.annotations.Test;

import com.util.ApiGeeUtil;
import com.util.ApigeePublicApiTest;
import com.util.FileUtils;

public class DownloadBundleLastRevisionScript extends ApigeePublicApiTest {

	private final String apiName = "loginapi";

	@Test
	public void testDownloadBundleLastRevisionScript() {

		InputStream bundle = getPublicApi().getApiBundle(apiName, 2, ApiGeeUtil.BUNDLE_FORMAT);

		FileUtils.streamToFile(bundle, apiName + ".zip");

	}

}
