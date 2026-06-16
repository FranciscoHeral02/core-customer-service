package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, String> {

}
