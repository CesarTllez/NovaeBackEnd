package com.company.novae.repository;

import com.company.novae.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {

    @Modifying
    public void update(@Param("id") Long id,
                       @Param("dni") Long dni,
                       @Param("name") String name,
                       @Param("email") String email);

    public Long countById(Long id);

    @Modifying
    @Query(value = "CALL update_client_procedure(:nameC, :emailC, :dniC);", nativeQuery = true)
    public void updateClientWithStoredProcess(@Param("nameC") String name,
                                              @Param("emailC") String email,
                                              @Param("dniC") Long dni);
}
