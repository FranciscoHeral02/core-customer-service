package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa;

import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.domain.ports.CustomerRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerAdapter implements CustomerRepositoryPort {
    private final CustomerJpaRepository jpaRepository;
    private final CustomerMapper mapper;

    @Override
    public Customer save(Customer partner) {

        return mapper.toDomain(jpaRepository.save(mapper.toEntity(partner)));
    }

    @Override
    public Optional<Customer> findById(String id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Boolean existsById(String id) {
        return jpaRepository.existsById(id);
    }
}
