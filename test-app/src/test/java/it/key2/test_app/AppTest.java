package it.key2.test_app;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void formatCurrencyInItalian() {
		BigDecimal number = new BigDecimal("0.69");
		App app = new App();
		final String formatted = app.formatCurrency(number, Locale.ITALY);
		assertEquals("0,69 €", formatted);
	}

	@Test
	public void formatCurrencyInItalianExceedingDecimals() {
		BigDecimal number = new BigDecimal("0.6923435138132066685185345");
		App app = new App();
		final String formatted = app.formatCurrency(number, Locale.ITALY);
		assertEquals("0,69 €", formatted);
	}

	@Test
	public void formatCurrencyInUSEnglish() {
		BigDecimal number = new BigDecimal("0.69");
		App app = new App();
		final String formatted = app.formatCurrency(number, Locale.US);
		assertEquals("$0.69", formatted);
	}

	@Test
	public void formatCurrencyInChinese() {
		BigDecimal number = new BigDecimal("0.69");
		App app = new App();
		final String formatted = app.formatCurrency(number, Locale.CHINA);
		assertEquals("¥0.69", formatted);
	}
}
