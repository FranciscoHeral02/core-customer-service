package dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest;

import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.CustomerRequest;
import dev.devfheral.coreclientservice.infrastructure.adapters.inbound.rest.dtos.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerHttpMapper {
    Customer toDomain(CustomerRequest customerResponse);
    CustomerResponse toResponse(Customer  customer);
}
