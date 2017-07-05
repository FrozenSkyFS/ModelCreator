package core;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {
	public static Map<String, String> getPropertiesMap(String path)
			throws IOException {
		Map<String, String> map = new HashMap<>();
		Properties prop = new Properties();
		prop.load(Thread.currentThread().getClass().getResourceAsStream(path));
		Enumeration<?> names = prop.propertyNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = prop.getProperty(name);
			map.put(name, value);
		}
		return map;
	}
}
