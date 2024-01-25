package com.pruebaTecnica.andrea.superheroes.infra.out;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import com.pruebaTecnica.andrea.superheroes.domain.repo.SuperheroeQueryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class SuperheroQueryRepository implements SuperheroeQueryRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Superheroe> retrieveAll() {
        return entityManager.createQuery("SELECT s FROM Superhero s", Superheroe.class).getResultList();
    }

    @Override
    public Optional<Superheroe> retrieveById(UUID id) {
        return Optional.ofNullable(entityManager.find(Superheroe.class, id));
    }
}