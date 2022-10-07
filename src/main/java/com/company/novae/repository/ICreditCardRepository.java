package com.company.novae.repository;

import com.company.novae.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Integer> {

    @Modifying
    public void update(@Param("id") Integer id,
                       @Param("primaryAccountNumber") Long primaryAccountNumber,
                       @Param("expMonth") Byte expMonth,
                       @Param("expYear") Integer expYear,
                       @Param("securityCode") Integer securityCode,
                       @Param("internationalBrand") String internationalBrand);

    public Long countById(Integer id);
}
