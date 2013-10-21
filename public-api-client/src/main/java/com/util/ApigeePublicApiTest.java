package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.apigee.ApigeeAPI;

@ContextConfiguration("classpath:/application-context.xml")
public class ApigeePublicApiTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private ApigeeAPI publicApi;

	protected ApigeeAPI getPublicApi() {
		return publicApi;
	}
}