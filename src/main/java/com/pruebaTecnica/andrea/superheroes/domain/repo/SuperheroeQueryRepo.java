package com.pruebaTecnica.andrea.superheroes.domain.repo;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SuperheroeQueryRepo {

    List<Superheroe> retrieveAll();
    Optional<Superheroe> retrieveById(UUID id);
}
