package com.company.novae.service.implementation;

import com.company.novae.dto.CreditCardDto;
import com.company.novae.entity.CreditCard;
import com.company.novae.repository.ICreditCardRepository;
import com.company.novae.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class CreditCardServiceImplementation implements ICreditCardService {

    @Autowired
    private ICreditCardRepository creditCardRepository;

    @Override
    public Set<CreditCardDto> findAll() {
        return null;
    }

    @Override
    public CreditCardDto findById(Integer id) {
        return null;
    }

    @Override
    public void create(CreditCard object) {

    }

    @Transactional
    @Override
    public void updateById(CreditCard object) {

    }

    @Override
    public void deleteById(Integer integer) {

    }
}
