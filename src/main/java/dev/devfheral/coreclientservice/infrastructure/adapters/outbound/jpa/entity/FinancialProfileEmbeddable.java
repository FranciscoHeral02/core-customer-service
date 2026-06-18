package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinancialProfileEmbeddable {
    int creditScore;
    String riskCategory;
    boolean hasCreditAlert;
    List<String> activeAlerts;
}
