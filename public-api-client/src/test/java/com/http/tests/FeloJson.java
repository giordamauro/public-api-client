package com.http.tests;

import java.util.AbstractMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class FeloJson {

	private static final int OFFUSCATE_CHARS = 10;

	public static void main(String[] args) {

		String payload = "{\"jSessionId\":\"oWbf2fVF3nKEUReTTl7qGa2\",\"headers\":{\"X-KO-APPL-TARGET-URL\":\"MCRAPI\",\"$WSPR\":\"HTTP/1.1\",\"User-Agent\":\"Apache-HttpClient/4.2.3 (java 1.5)\",\"Cookie\":\"JSESSIONID=0000oWbf2fVF3nKEUReTTl7qGa2:12006-us-mcrapi436; Path=/\",\"Host\":\"64.14.225.70\",\"_WS_HAPRT_WLMVERSION\":\"-1\",\"X-Forwarded-Proto\":\"https\",\"$WSIS\":\"false\",\"X-Forwarded-For\":\"201.235.94.12\",\"Content-Type\":\"application/json\",\"$WSRA\":\"107.23.127.111\",\"$WSSC\":\"http\",\"$WSRH\":\"107.23.127.111\",\"Authorization\":\"Basic bnVsbDpudWxs\",\"$WSSN\":\"64.14.225.70\",\"$WSSP\":\"80\",\"X-Forwarded-Port\":\"443\"},\"ficoSessionId\":\"wbQ0ULNPcYGuPErUFqIobWE4IUvbTl9+KgiJjMRthWI=\",\"parameters\":{\"memberId\":[\"2997118262\"],\"sessionId\":[\"wbQ0ULNPcYGuPErUFqIobWE4IUvbTl9+KgiJjMRthWI=\"]},\"cookies\":[{\"name\":\"JSESSIONID\",\"value\":\"0000oWbf2fVF3nKEUReTTl7qGa2:12006-us-mcrapi436\",\"comment\":null,\"domain\":null,\"maxAge\":-1,\"path\":null,\"secure\":false,\"version\":0}],\"remoteAddress\":\"201.235.94.12\",\"emailAddress\":\"kgjohnso@gmail.com\"}";

		// TODO Add real cookie titles
		String[] cookieTitles = { "JSESSIONID", "OTHERTITLE" };

		JsonElement response = new JsonParser().parse(payload);
		JsonObject responseObj = response.getAsJsonObject();

		Entry<String, String> titleEntry = getTitlesValue(responseObj, cookieTitles);
		String titleOffuscated = offuscate(titleEntry.getValue());
		responseObj.add(titleEntry.getKey(), new JsonPrimitive(titleOffuscated));

		JsonObject headers = responseObj.getAsJsonObject("headers");
		String cookie = headers.get("Cookie").getAsString();
		String strippedCookie = getCookieValue(cookie);
		String offuscatedCookie = offuscate(strippedCookie);
		System.out.println(offuscatedCookie);

		JsonArray cookies = responseObj.get("cookies").getAsJsonArray();

		Entry<String, String> cookieValue = getCookieValue(cookies, cookieTitles);
		System.out.println(offuscate(cookieValue.getValue()));

		System.out.println(responseObj);

	}

	private static final Entry<String, String> getTitlesValue(JsonObject object, String[] titles) {

		for (Entry<String, JsonElement> entry : object.entrySet()) {
			for (String title : titles) {
				String key = entry.getKey();
				if (key.equalsIgnoreCase(title)) {
					String value = entry.getValue().getAsString();
					Entry<String, String> titleEntry = new AbstractMap.SimpleEntry<String, String>(key, value);
					return titleEntry;
				}
			}
		}
		throw new IllegalStateException("Titles not found");
	}

	private static final Entry<String, String> getCookieValue(JsonArray array, String[] titles) {

		for (JsonElement element : array) {
			JsonObject cookie = element.getAsJsonObject();
			for (String title : titles) {
				String key = cookie.get("name").getAsString();
				if (key.equalsIgnoreCase(title)) {
					String value = cookie.get("value").getAsString();
					Entry<String, String> cookieEntry = new AbstractMap.SimpleEntry<String, String>(key, value);
					return cookieEntry;
				}
			}
		}
		throw new IllegalStateException("Titles not found");
	}

	private static final String getCookieValue(String cookie) {
		String strippedCookie = cookie.split("=")[1];
		strippedCookie = strippedCookie.split(";")[0];
		return strippedCookie;
	}

	private static final String offuscate(String value) {
		int offuscateLength = OFFUSCATE_CHARS;

		if (value.length() < OFFUSCATE_CHARS) {
			offuscateLength = value.length();
		}
		String off = "";
		for (int i = 0; i < offuscateLength; i++) {
			off += "*";
		}
		String offuscated = off + value.substring(offuscateLength, value.length());

		return offuscated;
	}
}
