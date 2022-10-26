package it.key2.test_app;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class NavigazioneE2E extends AbstractSeleniumE2E {
	@Test
	public void testDiNavigazione() {
		// Test name: Test di navigazione
		// Step # | name | target | value
		// 1 | open | /selenium-ide/ |
		driver.get("https://www.selenium.dev/selenium-ide/");
		// 2 | setWindowSize | 1920x1008 |
		driver.manage().window().maximize();
		// 3 | click | linkText=Docs |
		driver.findElement(By.linkText("Docs")).click();
		// 4 | click | linkText=Suites |
		driver.findElement(By.linkText("Suites")).click();
		// 5 | click | linkText=Help |
		driver.findElement(By.linkText("Help")).click();
		// 6 | click | linkText=get started |
		driver.findElement(By.linkText("get started")).click();
		// 7 | click | css=.docs-next > span:nth-child(1) |
		driver.findElement(By.cssSelector(".docs-next > span:nth-child(1)")).click();
		// 8 | click | css=.docMainWrapper |
		driver.findElement(By.cssSelector(".docMainWrapper")).click();
	}
}
