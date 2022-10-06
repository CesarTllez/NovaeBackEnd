package com.company.novae.controller;

import com.company.novae.dto.CreditCardDto;
import com.company.novae.entity.CreditCard;
import com.company.novae.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/credit-cards")
public class CreditCardController {

    @Autowired
    private ICreditCardService creditCardService;

    @GetMapping
    public Set<CreditCardDto> findAll() {
        return creditCardService.findAll();
    }

    @GetMapping("/{id}")
    public CreditCardDto findById(@PathVariable("id") Integer id) {
        return creditCardService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody CreditCard client) {
        creditCardService.create(client);
    }

    @PutMapping
    public void updateByID(@RequestBody CreditCard client) {
        creditCardService.updateById(client);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        creditCardService.deleteById(id);
    }
}
