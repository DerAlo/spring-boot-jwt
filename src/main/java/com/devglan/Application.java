package com.devglan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.mongobee.Mongobee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		mongobee();
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public static Mongobee mongobee() {
		Mongobee runner = new Mongobee("mongodb://127.0.0.1:27017/inntrade");
		runner.setChangeLogsScanPackage("com.devglan.model.mongobee");
		return runner;
	}

}
