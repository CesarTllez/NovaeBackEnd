package com.company.novae.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "franchise")
@NamedQuery(name = "Franchise.update", query = "UPDATE Franchise f SET f.name = :name WHERE f.id = :id")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "name", nullable = false)
    @Setter
    @Getter
    private String name;

    @OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<CreditCard> creditCards;

    public Franchise() {
    }
}
