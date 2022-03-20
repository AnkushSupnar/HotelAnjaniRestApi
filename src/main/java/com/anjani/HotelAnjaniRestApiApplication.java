package com.anjani;

import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelAnjaniRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelAnjaniRestApiApplication.class, args);
	}
//	@BeforeClass
//	public static void beforeAll(){
//		Json.mapper().registerModule(new Jdk8Module());
//		Json.mapper().registerModule(new JavaTimeModule());
//	}
}
