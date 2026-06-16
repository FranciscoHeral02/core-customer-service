package dev.devfheral.coreclientservice.application.service;

import dev.devfheral.coreclientservice.application.exceptions.CustomerNotFoundException;
import dev.devfheral.coreclientservice.application.ports.CustomerServicePort;
import dev.devfheral.coreclientservice.application.exceptions.CustomerAlreadyExistsException;
import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.domain.ports.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerServicePort {

    private final CustomerRepositoryPort repositoryPort;

    @Override
    public Customer createNewCustomer(Customer partner) {

        Customer partnerWithId = partner.initializeId();

        if (repositoryPort.existsById(partnerWithId.getCustomerId())) {
            throw new CustomerAlreadyExistsException();
        }
        return repositoryPort.save(partnerWithId);
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
        return repositoryPort.save(partner);
    }

}
