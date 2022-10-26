package or.sid.billingservice;

import feign.Logger;
import or.sid.billingservice.entities.Bill;
import or.sid.billingservice.entities.ProductItem;
import or.sid.billingservice.model.Customer;
import or.sid.billingservice.model.Product;
import or.sid.billingservice.repository.BillRepository;
import or.sid.billingservice.repository.ProductItemRepository;
import or.sid.billingservice.services.CustomerRestClient;
import or.sid.billingservice.services.InventoryRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            InventoryRestClient inventoryRestClient){
        return args -> {
            Long customerId=1L;
            Customer customer=customerRestClient.customerById(customerId);
            customer.setId(customerId);
            Collection<Product> productList=inventoryRestClient.allProducts().getContent();
            System.out.println(customer.toString());
            System.out.println(productList);
            Bill bill= Bill.builder().createdAt(new Date()).customerId(customerId).build();
            Bill savedBill = billRepository.save(bill);
            productList.forEach(p->{
                ProductItem productItem= ProductItem.builder()
                        .productId(p.getId())
                        .price(p.getPrice())
                        .quantity(new Random().nextInt(5))
                        .bill(savedBill)
                        .productId(p.getId())
                        .build();
                productItemRepository.save(productItem);
            });
        };
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
