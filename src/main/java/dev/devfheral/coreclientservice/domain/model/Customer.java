package dev.devfheral.coreclientservice.domain.model;

import lombok.Value;
import lombok.With;

@Value
public class Customer {
    @With String customerId;
    String docType;
    String docNum;
    String name;
    String type;
    String contactPerson;
    String email;
    Boolean valid;

    ContactInfo contactInfo;
    FinancialProfile financialProfile;

    public Customer initializeId() {
        String generatedId = this.docNum.concat(this.docType);
        return this.withCustomerId(generatedId);
    }
}
