package or.sid.billingservice.web;

import or.sid.billingservice.entities.Bill;
import or.sid.billingservice.entities.ProductItem;
import or.sid.billingservice.model.Customer;
import or.sid.billingservice.model.Product;
import or.sid.billingservice.repository.BillRepository;
import or.sid.billingservice.repository.ProductItemRepository;
import or.sid.billingservice.services.CustomerRestClient;
import or.sid.billingservice.services.InventoryRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {

    @Autowired private BillRepository billRepository;
    @Autowired private ProductItemRepository productItemRepository;
    @Autowired private CustomerRestClient customerRestClient;
    @Autowired private InventoryRestClient inventoryRestClient;

    @GetMapping("/fullBill/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerRestClient.customerById(bill.getCustomerId());
        bill.setCustomer(customer);
        for(ProductItem pi:bill.getProductItems()){
            Product product=inventoryRestClient.productById(pi.getProductId());
            System.out.println(product);
            pi.setProduct(product);
        }
        return bill;
    }
}
