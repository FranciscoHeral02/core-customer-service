package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.kafka;

import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.domain.ports.CustomerEventPublisherPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerEventAdapter implements CustomerEventPublisherPort {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishCustomerCreated(Customer customer) {

        applicationEventPublisher.publishEvent(customer);
    }

    @Override
    public void publishCustomerUpdated(Customer customer) {
        applicationEventPublisher.publishEvent(customer);
    }
}
