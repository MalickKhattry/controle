package org.sid.billingservice.entities;

import org.sid.billingservice.enums.billStatus;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
@CrossOrigin("*")
@Projection(name = "fullBill",types = Bill.class)
public interface BillProjection {
    Long getId();
    Date getbillingDate();
    Long getCustomerId();
    billStatus getStatus();
}
