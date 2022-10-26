package it.key2.test_app;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class AppServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String body = req.getReader().lines().collect(Collectors.joining());
		System.out.println(body);
		res.getWriter().println("Hello, %s!".formatted(body));
		res.getWriter().flush();
		res.getWriter().close();
		res.setStatus(200);
	}
}
