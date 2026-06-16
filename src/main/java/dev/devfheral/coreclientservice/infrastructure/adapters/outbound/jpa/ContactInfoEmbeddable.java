package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoEmbeddable {
    String telephone1;
    String telephone2;
    String address;
}
