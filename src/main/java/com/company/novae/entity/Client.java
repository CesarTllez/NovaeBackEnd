package com.company.novae.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
@NamedQuery(name = "Client.update", query = "UPDATE Client c SET c.dni = :dni, c.name = :name, c.email = :email WHERE c.id = :id")
public class Client extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "dni", nullable = false, unique = true)
    @Setter
    @Getter
    private Long dni;

    @Column(name = "name", nullable = false)
    @Setter
    @Getter
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Setter
    @Getter
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonIgnoreProperties("client")
    @Getter
    private Set<CreditCard> creditCards;

    public Client() {
    }
}
