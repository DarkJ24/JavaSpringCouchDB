package com.darkj24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class CouchDbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchDbTestApplication.class, args);
	}
}
