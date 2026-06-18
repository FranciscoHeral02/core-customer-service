package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa;

import dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, String> {

}
