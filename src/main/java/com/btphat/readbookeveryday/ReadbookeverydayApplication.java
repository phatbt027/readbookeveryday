package com.btphat.readbookeveryday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.btphat.readbookeveryday.entity")
public class ReadbookeverydayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadbookeverydayApplication.class, args);
	}

}
