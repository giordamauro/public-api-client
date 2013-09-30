package com.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Element;

import com.util.XmlUtils;

public class ReadXMLFile {

	public static final class Timestamp {

		private long time;

		private Map<String, String> properties;

		private int executionTime;

		public Long getTime() {
			return time;
		}

		public void setTime(Long time) {
			this.time = time;
		}

		public Map<String, String> getProperties() {
			return properties;
		}

		public void setProperties(Map<String, String> properties) {
			this.properties = properties;
		}

		public Timestamp(Long time, Map<String, String> properties) {
			super();
			this.time = time;
			this.properties = properties;
		}

		public String toString() {
			return String.valueOf(time) + " - " + properties.toString() + " : " + executionTime;
		}

		public int getExecutionTime() {
			return executionTime;
		}

		public void setExecutionTime(int executionTime) {
			this.executionTime = executionTime;
		}
	}

	public static void main(String[] args) {

		String filePath = "E:\\Dev\\projects\\4G\\cvs\\debug-data-js.xml";
		Element rootNode = XmlUtils.getRootelement(filePath);

		List<Element> points = XmlUtils.getChildren(rootNode, "Point");

		List<Timestamp> timeStamps = new ArrayList<Timestamp>();

		for (Element point : points) {
			String pointId = point.getAttributeValue("id");
			if (!pointId.equals("Paused") && !pointId.equals("Resumed")) {
				Element debugInfo = point.getChild("DebugInfo");
				Element timeStamp = debugInfo.getChild("Timestamp");
				String timestamp = timeStamp.getValue();

				Long time = getTimestampInMs(timestamp);

				Map<String, String> properties = getProperties(debugInfo.getChild("Properties"));

				Timestamp dto = new Timestamp(time, properties);

				timeStamps.add(dto);
			}
		}

		long lastTime = 0;
		for (Timestamp stamp : timeStamps) {
			int exec = (int) (stamp.getTime() - lastTime);
			stamp.setExecutionTime(exec);

			lastTime = stamp.getTime();
			System.out.println(exec + ": " + stamp.getProperties());
		}

	}

	private static Long getTimestampInMs(String timestamp) {

		try {
			Date date = new SimpleDateFormat("MM-dd-yy HH:mm:ss:SSS").parse(timestamp);
			return date.getTime();

		} catch (ParseException e) {
			throw new IllegalStateException(e);
		}
	}

	private static Map<String, String> getProperties(Element info) {

		Map<String, String> map = new HashMap<String, String>();

		List<Element> properties = XmlUtils.getChildren(info, "Property");
		for (Element property : properties) {
			String name = property.getAttributeValue("name");
			String value = property.getValue();

			map.put(name, value);
		}
		return map;
	}
}