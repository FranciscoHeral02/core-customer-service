package dev.devfheral.coreclientservice.application.service;

import dev.devfheral.coreclientservice.application.exceptions.CustomerAlreadyExistsException;
import dev.devfheral.coreclientservice.application.exceptions.CustomerNotFoundException;
import dev.devfheral.coreclientservice.application.ports.CustomerServicePort;
import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.domain.ports.CustomerEventPublisherPort;
import dev.devfheral.coreclientservice.domain.ports.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerServicePort {

  private final CustomerRepositoryPort repositoryPort;
  private final CustomerEventPublisherPort eventPublisherPort;

  @Override
  public Customer createNewCustomer(Customer partner) {

    Customer partnerWithId = partner.initializeId();

    if (repositoryPort.existsById(partnerWithId.getCustomerId())) {
      throw new CustomerAlreadyExistsException();
    }
    Customer savedCustomer = repositoryPort.save(partnerWithId);
    eventPublisherPort.publishCustomerCreated(savedCustomer);

    return savedCustomer;
  }

  @Transactional(readOnly = true)
  @Override
  public Customer findCustomerById(String id) {
    return repositoryPort.findById(id).orElseThrow(CustomerNotFoundException::new);
  }

  @Override
  public Customer updateCustomer(String id, Customer partner) {
    if (!repositoryPort.existsById(id)) {
      throw new CustomerNotFoundException();
    }
    Customer updatedCustomer = repositoryPort.save(partner);
    eventPublisherPort.publishCustomerUpdated(updatedCustomer);

    return updatedCustomer;
  }

}
