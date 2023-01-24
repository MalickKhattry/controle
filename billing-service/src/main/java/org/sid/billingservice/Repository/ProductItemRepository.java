package org.sid.billingservice.Repository;

import org.sid.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
