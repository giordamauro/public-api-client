package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.apigee.ApigeeAPI;
import com.apigee.ConfigurationManagementAPI;

@ContextConfiguration("classpath:/application-context.xml")
public class CurlApigeePublicApiTest extends AbstractTestNGSpringContextTests {

	@Autowired
	@Qualifier("curlApigeeApiFactoryBean")
	private ApigeeAPI publicApi;

	@Autowired
	@Qualifier("curlConfigurationManagementApiFactoryBean")
	private ConfigurationManagementAPI configurationManagamentAPI;

	protected ApigeeAPI getPublicApi() {
		return publicApi;
	}

	protected ConfigurationManagementAPI getConfigurationManagamentAPI() {
		return configurationManagamentAPI;
	}

}