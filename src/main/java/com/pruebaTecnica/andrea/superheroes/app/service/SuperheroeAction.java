package com.pruebaTecnica.andrea.superheroes.app.service;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SuperheroeAction {
    List<Superheroe> retrieveAll();
    Optional<Superheroe> retrieveById(UUID id);
    void create(Superheroe superhero);
    void update(UUID id, Superheroe superhero);

    void delete(UUID id);

}
