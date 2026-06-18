package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.kafka.dto;

import dev.devfheral.coreclientservice.domain.model.Customer;

public record CustomerKafkaPayload(
        CustomerEventType eventType,
        Customer data
) {}
