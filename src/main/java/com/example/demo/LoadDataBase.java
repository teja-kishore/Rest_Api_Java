package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(StudentDetailsRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new StudentDetails("Teja")));
            log.info("Preloading " + repository.save(new StudentDetails("Kishore")));
        };
    }
}
