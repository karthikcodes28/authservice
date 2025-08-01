package com.karthik.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan("com/karthik/auth/Model")
@EnableDiscoveryClient
public class AuthServiceApplication implements CommandLineRunner {
	@Autowired
	public PasswordEncoder passwordEncoder;


	public static void main(String[] args) {

		SpringApplication.run(AuthServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("testing"));
	}

}
