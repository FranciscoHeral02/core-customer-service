package dev.devfheral.coreclientservice.domain.ports;

import dev.devfheral.coreclientservice.domain.model.Customer;

import java.util.Optional;

public interface CustomerRepositoryPort {
    Customer save(Customer partner);
    Optional<Customer> findById(String id);
    Boolean existsById(String id);
}
