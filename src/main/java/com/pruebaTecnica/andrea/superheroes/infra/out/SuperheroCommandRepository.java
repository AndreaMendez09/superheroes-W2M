package com.pruebaTecnica.andrea.superheroes.infra.out;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import com.pruebaTecnica.andrea.superheroes.domain.repo.SuperheroeCommandRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class SuperheroCommandRepository implements SuperheroeCommandRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Superheroe superhero) {
        entityManager.persist(superhero);
    }

    @Override
    @Transactional
    public void update(UUID id, Superheroe superhero) {
        var toUpdate = entityManager.find(Superheroe.class, id);
        if (toUpdate != null) {
            entityManager.merge(superhero);
        }
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Superheroe superhero = entityManager.find(Superheroe.class, id);
        if (superhero != null) {
            entityManager.remove(superhero);
        }
    }
}