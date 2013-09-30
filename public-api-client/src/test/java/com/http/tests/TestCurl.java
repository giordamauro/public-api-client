package com.http.tests;

import com.util.Curl;

public class TestCurl {

	public static void main(String[] args) throws Exception {

		// Deploy new apiProxy(o revision):
		// CmdUtils.execCommand("curl -k -v -H \"Content-Type: application/octet-stream\" -X POST https://api.enterprise.apigee.com/v1/o/mgiorda/apis?action=import&name=Deals -T C://deals.zip -u mgiorda@apigee.com:1234321Nomejodas");

		// Two alternatives to do the same call:

		// Curl.get("https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test/deployments").setUser("mgiorda@apigee.com",
		// "1234321Nomejodas").send();

		// Curl.get("https://api.enterprise.apigee.com/v1/organizations/mgiorda/environments/test/caches/mycache/entries").setUser("mgiorda@apigee.com",
		// "1234321Nomejodas").send();

		// Curl.get("http://management-server:8080/v1/servers/self/reachable").setUser("admin",
		// "4G,ftw").send();

		// -u myname:mypass
		// https://api.enterprise.apigee.com/v1/o/{myorg}/environments/test/targetservers
		// CmdUtils.execCommand("curl -k -v https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test -u mgiorda@apigee.com:1234321Nomejodas");

		// Curl.get("https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test/targetservers").setUser("mgiorda@apigee.com",
		// "1234321Nomejodas").send();

		// Curl.post("https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test/targetservers").setUser("mgiorda@apigee.com",
		// "1234321Nomejodas")
		// .setJsonData("{\"name\":\"target4\",\"host\":\"http://www.google.com\",\"port\":80,\"isenabled\":true}").send();

		// CmdUtils.execCommand("curl -k -v -X POST https://api.enterprise.apigee.com/v1/organizations/mgiorda/developers/craig.schumann@infogroup.com/apps/MyTestApp/keys/KVFvu7AbygYXcWEzr9cg8cIH0y0Tk5Re?action=approve -u mgiorda@apigee.com:1234321Nomejodas");

		// Curl.post("http://cvs-test.apigee.net/v1/test-login-cookie/loginUser")
		// .setData("application/xml",
		// "<parameters><arg1>user.cindy@yahoo.com</arg1><arg2>abcd1234</arg2><arg3>true</arg3></parameters>").send();

		// Curl.post("http://mgiorda-test.apigee.net/v1/profileServices/loginUser").addHeader("Content-Length",
		// "0").send();
		// -------------------------------------------------------------------------
		// Worldbank queries.
		// Curl.get(
		// "https://api.enterprise.apigee.com/v1/o/mgiorda/environments/prod/stats/apis?select=sum(message_count)&timeUnit=month&timeRange=08/20/2013%2000:00~10/01/2013%2000:00&filter=(apiproxy%20eq%20'worldbank')")
		// .setUser("mgiorda@apigee.com", "1234321Nomejodas").send();

		// Curl.get(
		// "https://api.enterprise.apigee.com/v1/o/mgiorda/environments/prod/stats/domain?select=sum(message_count)&timeUnit=month&timeRange=08/01/2013%2000:00~08/31/2013%2023:59&filter=(apiproxy%20eq%20'worldbank')")
		// .setUser("mgiorda@apigee.com", "1234321Nomejodas").send();
		// ---------------------------------------------------
		// Curl.get(
		// "https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test/stats/cachehit?select=sum(message_count)&timeUnit=month&timeRange=09/05/2012%2000:00~09/5/2014%2000:00&filter=(apiproxy%20eq%20'worldbank-bundle')")
		// .setUser("mgiorda@apigee.com", "1234321Nomejodas").send();

		// Curl.get("https://api.enterprise.apigee.com/v1/organizations/mgiorda/environments/test/stats/messageview?limit=100&timeRange=09/19/2013%2000:00~09/20/2014%2023:59")
		// .setUser("mgiorda@apigee.com",
		// "1234321Nomejodas").addOptionValue(">", "data.json").send();

		// Curl.get(
		// "https://api.enterprise.apigee.com/v1/o/mgiorda/e/test/stats/?select=sum(message_count)&timeUnit=month&timeRange=09/01/2013%2000:00~09/31/2013%2023:59&filter=(apiproxy%20eq%20'worldbank')")
		// .setUser("mgiorda@apigee.com", "1234321Nomejodas").send();

		Curl.get(
				"https://api.enterprise.apigee.com/v1/o/mgiorda/environments/test/stats/apis?select=sum(cache_hit)&timeUnit=month&timeRange=08/01/2013%2000:00~08/31/2014%2023:59&filter=(apiproxy%20eq%20'worldbank-bundle')")
				.setUser("mgiorda@apigee.com", "1234321Nomejodas").send();
	}
}
