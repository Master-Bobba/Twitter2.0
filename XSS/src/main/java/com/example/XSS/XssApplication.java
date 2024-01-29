package com.example.XSS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class XssApplication {

	private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	public static void main(String[] args) {
		SpringApplication.run(XssApplication.class, args);
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry reg) {
				reg.addMapping("/**").allowedOrigins("*");
			}
		};
	}

}
