package br.com.selenium.for_beginners.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HandleProperties {

	private static final String PROPERTIES = "./src/resources/config.properties";

	private static Properties properties;
		
	public static String getValue(String value) {
		try {
			if(properties == null) {
				HandleProperties.properties = new Properties();
				HandleProperties.properties.load( new FileInputStream(PROPERTIES));
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return HandleProperties.properties.getProperty(value);
	}
}