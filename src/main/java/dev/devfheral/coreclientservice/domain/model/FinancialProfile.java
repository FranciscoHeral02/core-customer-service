package dev.devfheral.coreclientservice.domain.model;

import lombok.Value;

import java.util.List;

@Value
public class FinancialProfile {
    int creditScore;
    String riskCategory;
    boolean hasCreditAlert;
    List<String> activeAlerts;
}
