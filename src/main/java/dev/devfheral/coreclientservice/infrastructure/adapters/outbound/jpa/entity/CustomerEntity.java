package dev.devfheral.coreclientservice.infrastructure.adapters.outbound.jpa.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

  @Id
  String customerId;
  String docType;
  String docNum;
  String name;
  String type;
  String contactPerson;
  String email;
  Boolean valid;

  @Embedded
  private ContactInfoEmbeddable contactInfo;

  @Embedded
  private FinancialProfileEmbeddable financialProfile;
}
