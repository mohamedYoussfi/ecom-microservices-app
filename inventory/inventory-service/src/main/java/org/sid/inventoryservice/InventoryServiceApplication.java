package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            for (int i = 100; i <110 ; i++) {
                productRepository.save(Product.builder().name("Computer "+i).quantity(34).price(54300).build());
                productRepository.save(Product.builder().name("Printer "+i).quantity(11).price(1200).build());
                productRepository.save(Product.builder().name("Smart Phone "+i).quantity(13).price(1400).build());
            }
        };
    }
}
@RestController
class InventoryController{
    @Value("${inventory.param1}")
    private String param1;
    @Value("${inventory.param2}")
    private String param2;
    @GetMapping("/params")
    public Map<String,String> getParams(){
       return Map.of("param1",param1,"param2",param2);
   }
}

