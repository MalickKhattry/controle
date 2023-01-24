package org.sid.billingservice.Repository;

import feign.Param;
import org.sid.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill,Long> {
@RestResource(path = "/byCustomerId")
    List <Bill> findByCustomerId(@Param("customerId") Long customerId);
}
