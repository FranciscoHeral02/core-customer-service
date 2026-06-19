package dev.devfheral.coreclientservice.domain.ports;

import dev.devfheral.coreclientservice.domain.model.Customer;
import dev.devfheral.coreclientservice.domain.model.FinancialProfile;

public interface CreditRiskEvaluationPort {
  FinancialProfile getCreditRiskProfile(Customer customer);
}

