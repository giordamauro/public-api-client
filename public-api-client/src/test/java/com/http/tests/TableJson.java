package com.http.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.util.FileUtils;

public class TableJson {

	public static void main(String[] args) {

		String json = FileUtils.readFileAsString("C://data.json");

		JsonElement response = new JsonParser().parse(json);
		JsonObject responseObj = response.getAsJsonObject();

		JsonArray columns = responseObj.get("columns").getAsJsonArray();
		JsonArray messages = responseObj.get("messages").getAsJsonArray();

		List<Map<String, String>> tableValues = new ArrayList<Map<String, String>>();

		for (int i = 0; i < messages.size(); i++) {
			JsonObject message = messages.get(i).getAsJsonObject();
			JsonArray messageValues = message.get("message").getAsJsonArray();

			Map<String, String> values = new HashMap<String, String>();
			for (int j = 0; j < columns.size(); j++) {
				String column = columns.get(j).getAsString();
				String value = messageValues.get(j).getAsString();

				values.put(column, value);
			}

			tableValues.add(values);
		}

		List<String> values = getColumnValues(tableValues, "cachehit");

		System.out.println(values);

		int cacheHits = 0;
		for (String value : values) {
			if (value != null && value.equals("1")) {
				cacheHits++;
			}
		}

		System.out.println(cacheHits);
	}

	private static List<String> getColumnValues(List<Map<String, String>> tableValues, String columnName) {

		List<String> values = new ArrayList<String>();

		for (Map<String, String> map : tableValues) {

			if (map.containsKey(columnName)) {

				values.add(map.get(columnName));
			} else {
				throw new IllegalStateException(String.format("Column named '%s' does not exist", columnName));
			}
		}
		return values;
	}

}
