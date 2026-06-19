package dev.devfheral.coreclientservice.application.ports;

import dev.devfheral.coreclientservice.domain.model.Customer;

public interface CustomerServicePort {
  Customer createNewCustomer(Customer partner);

  Customer findCustomerById(String id);

  Customer updateCustomer(String id, Customer partner);
}