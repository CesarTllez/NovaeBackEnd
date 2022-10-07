package com.company.novae.service;

import java.util.Set;

public interface ICRUDService<Object, Id, ObjectDto> {
    public Set<ObjectDto> findAll();

    public ObjectDto findById(Id id);

    public void create(Object object);

    public void update(Object object);

    public void deleteById(Id id);
}
