package com.company.novae.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ClientDto {
    private Long id;
    private Long dni;
    private String name;
    private String email;
    private String cratedBy;
    private Date createdDate;
    private String lastModifiedBy;
    private Date lastModifiedDate;

    public ClientDto() {
    }
}
