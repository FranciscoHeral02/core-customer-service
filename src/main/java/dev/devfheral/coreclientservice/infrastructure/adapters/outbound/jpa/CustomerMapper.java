package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa;

import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    CustomerEntity toEntity(Customer domain);
    Customer toDomain(CustomerEntity entity);
}
