package org.example.grandao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The type Gran dao application.
 */
@EnableCaching
@SpringBootApplication
public class GranDaoApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		SpringApplication.run(GranDaoApplication.class, args);
	}

}
