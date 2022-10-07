package com.company.novae.service.implementation;

import com.company.novae.dto.CreditCardDto;
import com.company.novae.entity.CreditCard;
import com.company.novae.exceptions.NotFoundException;
import com.company.novae.repository.ICreditCardRepository;
import com.company.novae.service.ICreditCardService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
        ModelMapper mapper = new ModelMapper();
        Set<CreditCardDto> creditCardDtos = mapper.map(
                creditCardRepository.findAll(),
                new TypeToken<Set<CreditCardDto>>() {
                }.getType());

        for (CreditCardDto creditCardDtoAux : creditCardDtos) {
            creditCardDtoAux.setFranchiseId(creditCardRepository.findById(creditCardDtoAux.getId())
                    .get().getFranchise().getId());
            creditCardDtoAux.setClientId(creditCardRepository.findById(creditCardDtoAux.getId())
                    .get().getClient().getId());
        }
        return creditCardDtos;
    }

    @Override
    public CreditCardDto findById(Integer id) {
        ModelMapper mapper = new ModelMapper();
        if (creditCardRepository.findById(id).isPresent()) {
            CreditCard creditCard = creditCardRepository.findById(id).get();
            CreditCardDto creditCardDto = mapper.map(creditCard, CreditCardDto.class);
            creditCardDto.setFranchiseId(creditCard.getFranchise().getId());
            creditCardDto.setClientId(creditCard.getClient().getId());
            return creditCardDto;
        }
        throw new NotFoundException("");
    }

    @Override
    public void create(CreditCard creditCard) {
        creditCardRepository.save(creditCard);
    }

    @Transactional
    @Override
    public void update(CreditCard creditCard) {
        if (creditCardRepository.countById(creditCard.getId()) == 1)
            creditCardRepository.update(
                    creditCard.getId(),
                    creditCard.getPrimaryAccountNumber(),
                    creditCard.getExpMonth(),
                    creditCard.getExpYear(),
                    creditCard.getSecurityCode(),
                    creditCard.getInternationalBrand());
        else throw new NotFoundException("");
    }

    @Override
    public void deleteById(Integer id) {
        if (creditCardRepository.countById(id) == 1)
            creditCardRepository.deleteById(id);
        else throw new NotFoundException("");
    }
}
