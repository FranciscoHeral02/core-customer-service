package dev.devfheral.coreclientservice.domain.ports;

import dev.devfheral.coreclientservice.domain.model.Customer;

public interface CustomerEventPublisherPort {
    void publishCustomerCreated(Customer customer);
    void publishCustomerUpdated(Customer customer);
}
