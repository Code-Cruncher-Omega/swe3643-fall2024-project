package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
				.properties("spring.config.location=src/web/src/main/resources/application.properties")
				.run(args);
	}

}