package it.key2.test_app;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppIT {
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	void jettyHello() throws IOException {
		URL url = new URL("http://localhost:8080/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		DataOutputStream out = new DataOutputStream(con.getOutputStream());
		out.writeBytes("Bobby");
		out.flush();
		out.close();
		int status = con.getResponseCode();
		assertEquals(200, status);

		try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
			StringBuilder response = new StringBuilder();
			String responseLine;
			while ((responseLine = in.readLine()) != null) {
				response.append(responseLine.trim());
			}
			assertEquals("Hello, Bobby!", response.toString());
		}
		con.disconnect();
	}
}
