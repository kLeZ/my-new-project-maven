package it.key2.test_app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractSeleniumE2E {
	public WebDriver driver;

	@BeforeAll
	public static void setDriver() {
		Properties props = new Properties();
		try {
			props.load(App.class.getResourceAsStream("/application.properties"));
			final String driverVersion = props.getProperty("selenium.driver.version");
			WebDriverManager.chromiumdriver().driverVersion(driverVersion).setup();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@BeforeEach
	public void setup() {
		driver = new ChromeDriver();
	}

	@AfterEach
	public void quit() {
		driver.quit();
	}
}
