package or.sid.billingservice.services;

import or.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryRestClient {
    @GetMapping(path = "/products?projection=p1")
    public PagedModel<Product> allProducts();
    @GetMapping(path = "/products/{id}?projection=p1")
    public Product productById(@PathVariable(name = "id") Long id);
}
