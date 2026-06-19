package dev.devfheral.coreclientservice.domain.model;

import java.util.List;
import lombok.Value;

@Value
public class FinancialProfile {
  int creditScore;
  String riskCategory;
  boolean hasCreditAlert;
  List<String> activeAlerts;
}
