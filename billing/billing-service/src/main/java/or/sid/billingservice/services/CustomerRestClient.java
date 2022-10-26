package or.sid.billingservice.services;

import or.sid.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{id}")
    public Customer customerById(@PathVariable Long id);
}
