package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.kafka;

import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.infrastructure.adapters.outbound.kafka.dto.CustomerEventType;
import dev.devfheral.coreclientservice.infrastructure.adapters.outbound.kafka.dto.CustomerKafkaPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaEventBridgeListener {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.customer-topic}")
    private String customerTopic;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCustomerCreated(Customer customer) {
        CustomerKafkaPayload payload = new CustomerKafkaPayload(CustomerEventType.CUSTOMER_CREATED, customer);

        kafkaTemplate.send(customerTopic, String.valueOf(customer.getCustomerId()), payload);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCustomerUpdated(Customer customer) {

        CustomerKafkaPayload payload = new CustomerKafkaPayload(CustomerEventType.CUSTOMER_UPDATED, customer);

        kafkaTemplate.send(customerTopic, String.valueOf(customer.getCustomerId()), payload);
    }
}

