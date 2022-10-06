package com.company.novae.repository;

import com.company.novae.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    @Modifying
    public void updateById(@Param("id") Long id,
                           @Param("name") String name,
                           @Param("email") String email);
}
