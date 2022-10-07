package com.company.novae.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDto {
    private Long id;
    private Long dni;
    private String name;
    private String email;

    public ClientDto() {
    }
}
