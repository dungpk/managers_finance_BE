package com.example.cg_finance_managers;

import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Transactional
public class CgFinanceManagersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgFinanceManagersApplication.class, args);
	}

}
