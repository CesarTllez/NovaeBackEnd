package com.company.novae.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "credit_Card")
@NamedQuery(name = "CreditCard.update", query = "UPDATE CreditCard c SET " +
        "c.primaryAccountNumber = :primaryAccountNumber, " +
        "c.expMonth = :expMonth, " +
        "c.expYear = :expYear, " +
        "c.securityCode = :securityCode, " +
        "c.internationalBrand = :internationalBrand " +
        "WHERE c.id = :id")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "primary_account_number", nullable = false, unique = true)
    @Setter
    @Getter
    private Long primaryAccountNumber;

    @Column(name = "expiration_month", nullable = false)
    @Setter
    @Getter
    private Byte expMonth;

    @Column(name = "expiration_year", nullable = false)
    @Setter
    @Getter
    private Integer expYear;

    @Column(name = "security_code", nullable = false)
    @Setter
    @Getter
    private Integer securityCode;

    @Column(name = "international_brand")
    @Setter
    @Getter
    private String internationalBrand;

    @ManyToOne
    @JoinColumn(name = "franchise_id", nullable = false)
    @Getter
    private Franchise franchise;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @Getter
    private Client client;

    public CreditCard() {
    }
}
