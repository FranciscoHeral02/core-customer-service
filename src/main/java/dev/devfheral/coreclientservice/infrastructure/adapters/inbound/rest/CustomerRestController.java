package dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest;

import dev.devfheral.coreclientservice.application.ports.CustomerServicePort;
import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.CustomerRequest;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.CustomerResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomerRestController implements CustomerApi {

  private final CustomerServicePort servicePort;
  private final CustomerHttpMapper httpMapper;

  @Override
  public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerRequest) {

    Customer customer = servicePort.createNewCustomer(httpMapper.toDomain(customerRequest));
    CustomerResponse customerResponse = httpMapper.toResponse(customer);

    return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<CustomerResponse> getCustomerById(String id) {
    Customer customer = servicePort.findCustomerById(id);
    CustomerResponse customerResponse = httpMapper.toResponse(customer);
    return new ResponseEntity<>(customerResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CustomerResponse> updateCustomer(String id,
                                                         CustomerRequest customerRequest) {
    Customer customer = servicePort.updateCustomer(id, httpMapper.toDomain(customerRequest));
    CustomerResponse customerResponse = httpMapper.toResponse(customer);

    return ResponseEntity.ok().body(customerResponse);
  }
}
