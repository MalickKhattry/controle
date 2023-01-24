package org.sid.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.billingservice.enums.billStatus;
import org.sid.billingservice.model.Customer;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill {

    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private billStatus status;
@OneToMany(mappedBy = "bill")
    private Collection<ProductItem>  productItems;
    private Long customerId;
    @Transient
    private Customer customer;
    public double getTotal(){
        double somme=0;
         for (ProductItem pi:productItems){
             somme+=pi.getAmount();

         }
         return somme;
    }
}
