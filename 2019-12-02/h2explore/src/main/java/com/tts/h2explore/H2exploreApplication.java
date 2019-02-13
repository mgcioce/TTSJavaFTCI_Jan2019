package com.tts.h2explore;

import com.tts.h2explore.domain.Customer;
import com.tts.h2explore.domain.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class H2exploreApplication {

    public static void main(String[] args) {
        SpringApplication.run(H2exploreApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository repository) {
        return args -> {
        repository.save( new Customer("Jimmy", "Dang"));
        };
    }
}

