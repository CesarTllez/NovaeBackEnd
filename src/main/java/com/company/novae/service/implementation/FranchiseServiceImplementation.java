package com.company.novae.service.implementation;

import com.company.novae.entity.Franchise;
import com.company.novae.exceptions.NotFoundException;
import com.company.novae.repository.IFranchiseRepository;
import com.company.novae.service.IFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class FranchiseServiceImplementation implements IFranchiseService {

    @Autowired
    private IFranchiseRepository franchiseRepository;

    @Override
    public Set<Franchise> findAll() {
        return new HashSet<>(franchiseRepository.findAll());
    }

    @Override
    public Franchise findById(Integer id) {
        if (franchiseRepository.findById(id).isPresent())
            return franchiseRepository.findById(id).get();
        throw new NotFoundException("");
    }

    @Override
    public void create(Franchise franchise) {
        franchiseRepository.save(franchise);
    }

    @Transactional
    @Override
    public void update(Franchise franchise) {
        if (franchiseRepository.countById(franchise.getId()) == 1)
            franchiseRepository.update(franchise.getId(), franchise.getName());
        else throw new NotFoundException("");
    }

    @Override
    public void deleteById(Integer id) {
        if (franchiseRepository.countById(id) == 1) franchiseRepository.deleteById(id);
        else throw new NotFoundException("");
    }
}
