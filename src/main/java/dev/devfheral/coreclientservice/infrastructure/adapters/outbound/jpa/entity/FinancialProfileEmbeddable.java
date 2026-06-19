package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa.entity;

import jakarta.persistence.Embeddable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
