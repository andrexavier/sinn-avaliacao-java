package br.com.sinn.sinnApp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SinnTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinnTestApplication.class, args);
	}
}
