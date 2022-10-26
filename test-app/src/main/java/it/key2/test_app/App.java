package it.key2.test_app;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
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

	public String formatCurrency(BigDecimal number, Locale locale) {
		return NumberFormat.getCurrencyInstance(locale).format(number.doubleValue());
	}
}
