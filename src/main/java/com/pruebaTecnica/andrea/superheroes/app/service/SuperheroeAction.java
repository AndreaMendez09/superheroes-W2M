package com.pruebaTecnica.andrea.superheroes.app.service;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;

import java.util.List;


public interface SuperheroeAction {
    List<Superheroe> retrieveAll();
    Superheroe retrieveById(Long id);
    List<Superheroe> retrieveByName(String name);
    void create(Superheroe superhero);
    void update(Long id, Superheroe superhero);

    void delete(Long id);

}
