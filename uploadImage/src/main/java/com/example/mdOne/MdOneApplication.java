package com.example.mdOne;

import org.hibernate.dialect.SybaseSqmToSqlAstConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MdOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdOneApplication.class, args);

		System.out.println("Mdau first.....");
	}
}
