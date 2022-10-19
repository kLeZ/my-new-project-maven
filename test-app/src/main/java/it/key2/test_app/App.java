package it.key2.test_app;

import java.io.IOException;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Properties props = new Properties();
		try {
			props.load(App.class.getResourceAsStream("/application.properties"));
            System.out.println(props.getProperty("jdbc.connection.url"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
