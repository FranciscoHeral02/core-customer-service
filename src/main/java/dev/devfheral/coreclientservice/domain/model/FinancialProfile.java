package dev.devfheral.coreclientservice.domain.model;

import lombok.Value;

@Value
public class FinancialProfile {
    int creditScore;
    String riskCategory;
    boolean hasCreditAlert;
}
