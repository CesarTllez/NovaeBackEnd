package com.company.novae.repository;

import com.company.novae.entity.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFranchiseRepository extends JpaRepository<Franchise, Integer> {
    @Modifying
    public void updateById(@Param("id") Integer id,
                           @Param("name") String name);
}
