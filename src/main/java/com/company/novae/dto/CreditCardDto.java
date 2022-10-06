package com.company.novae.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreditCardDto {
    private Integer id;
    private Long primaryAccountNumber;
    private String holder;
    private Byte expMounth;
    private Integer expYear;
    private String internationalBrand;
    private Integer securityCode;
    private Integer franchiseId;
    private Long clientId;

    public CreditCardDto() {
    }
}
