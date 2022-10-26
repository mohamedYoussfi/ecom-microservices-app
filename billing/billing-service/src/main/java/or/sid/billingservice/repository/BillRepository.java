package or.sid.billingservice.repository;

import or.sid.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
    @RestResource(path = "/billsByCustomerId")
    List<Bill> findByCustomerId(@Param("id")Long customerId);
}
