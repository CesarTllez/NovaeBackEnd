package com.company.novae.controller;

import com.company.novae.entity.Franchise;
import com.company.novae.service.IFranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/franchises")
public class FranchiseController {

    @Autowired
    private IFranchiseService franchiseService;

    @GetMapping
    public Set<Franchise> findAll() {
        return franchiseService.findAll();
    }

    @GetMapping("/{id}")
    public Franchise findById(@PathVariable("id") Integer id) {
        return franchiseService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Franchise franchise) {
        franchiseService.create(franchise);
    }

    @PutMapping
    public void update(@RequestBody Franchise franchise) {
        franchiseService.update(franchise);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        franchiseService.deleteById(id);
    }
}
