package org.sid.inventoryservice.repositories;

import org.sid.inventoryservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    @RestResource(path = "/byName")
    Page<Product> findByNameContains(@Param("keyword") String keyword, Pageable pageable);
}
