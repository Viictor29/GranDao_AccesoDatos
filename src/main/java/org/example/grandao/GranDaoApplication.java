package org.example.grandao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GranDaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GranDaoApplication.class, args);
	}

}
