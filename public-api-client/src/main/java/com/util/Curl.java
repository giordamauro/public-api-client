package com.util;

import java.util.ArrayList;
import java.util.List;

public class Curl {

	private static final String JSON_CONTENT_TYPE = "application/json";
	private static final String XML_CONTENT_TYPE = "text/xml";

	private List<String> options = new ArrayList<String>();

	private Curl(String path) {
		options.add("curl");
		options.add("-k");
		options.add("-v");
		options.add(path);
	}

	public String send() {
		return CmdUtils.excecListOptions(options);
	}

	public Curl setUser(String username, String password) {
		this.addOptionValue("-u", username + ":" + password);
		return this;
	}

	public Curl addOption(String option) {
		options.add(option);
		// TODO -> ALLOW ONLY KNOWN OPTIONS
		return this;
	}

	public Curl addHeader(String name, String value) {
		this.addOptionValue("-H", name + ":" + value);
		return this;
	}

	public Curl setData(String contentType, String data) {
		this.addHeader("Content-type", contentType);
		String escapedData = data.replaceAll("\"", "\\\\\"");
		this.addOptionValue("-d", "\"" + escapedData + "\"");

		return this;
	}

	public Curl setJsonData(String jsonData) {
		this.setData(JSON_CONTENT_TYPE, jsonData);
		return this;
	}

	public Curl setXmlData(String xmlData) {
		this.setData(XML_CONTENT_TYPE, xmlData);
		return this;
	}

	public Curl addOptionValue(String option, String value) {
		options.add(option);
		options.add(value);
		return this;
	}

	private void setMethod(String method) {
		this.addOptionValue("-X", method);
	}

	public static Curl get(String path) {
		return new Curl(path);
	}

	public static Curl post(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("POST");
		return curl;
	}

	public static Curl put(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("PUT");
		return curl;
	}

	public static Curl delete(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("DELETE");
		return curl;
	}

	public static Curl options(String path) {
		Curl curl = new Curl(path);
		curl.setMethod("OPTIONS");
		return curl;
	}
}
