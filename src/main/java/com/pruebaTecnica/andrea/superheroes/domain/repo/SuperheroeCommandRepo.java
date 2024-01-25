package com.pruebaTecnica.andrea.superheroes.domain.repo;


import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface SuperheroeCommandRepo {
    void save(Superheroe superhero);

    void update(UUID id, Superheroe superhero);

    void delete(UUID id);
}