package com.pruebaTecnica.andrea.superheroes.app.service;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import com.pruebaTecnica.andrea.superheroes.domain.repo.SuperheroeCommandRepo;
import com.pruebaTecnica.andrea.superheroes.domain.repo.SuperheroeQueryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SuperheroeService implements SuperheroeAction {

    private final SuperheroeCommandRepo superheroCommandRepo;
    private final SuperheroeQueryRepo superheroeQueryRepo;


    @Autowired
    public SuperheroeService(SuperheroeCommandRepo superheroRepo, SuperheroeQueryRepo superheroeQueryRepo) {
        this.superheroCommandRepo = superheroRepo;
        this.superheroeQueryRepo = superheroeQueryRepo;
    }

    @Override
    public List<Superheroe> retrieveAll() {
        return superheroeQueryRepo.retrieveAll();
    }

    @Override
    public Optional<Superheroe> retrieveById(UUID id) {
        return superheroeQueryRepo.retrieveById(id);
    }

    @Override
    public void create(Superheroe superhero) {
        superheroCommandRepo.save(superhero);
    }

    @Override
    public void update(UUID id,Superheroe superhero) {
        superheroCommandRepo.update(id,superhero);
    }

    @Override
    public void delete(UUID id) {
        superheroCommandRepo.delete(id);
    }
}