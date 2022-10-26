package org.sid.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customerProj1",types = Customer.class)
public interface CustomerProjection {
    Long getId();
    String getName();
    String getEmail();
}
