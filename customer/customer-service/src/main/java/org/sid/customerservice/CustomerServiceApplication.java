package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sid.customerservice.repository.CustomerRepository;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            List.of(
                    Customer.builder().name("Enset").email("enset@gmail.com").build(),
                    Customer.builder().name("UH2C").email("uh2C@gmail.com").build()
            ).forEach(customer -> {
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
