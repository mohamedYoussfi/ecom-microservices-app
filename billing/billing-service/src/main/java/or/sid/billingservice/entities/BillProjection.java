package or.sid.billingservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "billProj1", types = Bill.class)
public interface BillProjection {
    Long getId();
    Date getCreatedAt();
    Long getCustomerId();
}
