package com.pruebaTecnica.andrea.superheroes.app.service;

import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import com.pruebaTecnica.andrea.superheroes.domain.repo.SuperheroeCommandRepo;
import com.pruebaTecnica.andrea.superheroes.infra.in.exception.SuperheroeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@CacheConfig(cacheNames = "superheroe-cache")
public class SuperheroeService implements SuperheroeAction {

    private final SuperheroeCommandRepo superheroCommandRepo;


    @Autowired
    public SuperheroeService(SuperheroeCommandRepo superheroRepo) {
        this.superheroCommandRepo = superheroRepo;
    }

    @Override
    @Cacheable
    public List<Superheroe> retrieveAll() {
        return superheroCommandRepo.findAll();
    }

    @Override
    @Cacheable
    public Superheroe retrieveById(Long id) {
        return superheroCommandRepo.findById(id).orElseThrow(() -> new SuperheroeNotFoundException("Superheroe not found with the given ID"));
    }

    @Override
    public List<Superheroe> retrieveByName(String name) {
        List<Superheroe> superheroes = superheroCommandRepo.findByNameContains(name);

        if (superheroes.isEmpty()) {
            throw new SuperheroeNotFoundException("Superheroe not found with the givena name: " + name);
        }

        return superheroes;    }

    @Override
    public void create(Superheroe superhero) {
        superheroCommandRepo.save(superhero);
    }

    @Override
    public void update(Long id,Superheroe superhero) {
        superheroCommandRepo.findById(superhero.getId()).orElseThrow(() -> new SuperheroeNotFoundException("Superheroe not found with the given ID."));
        superheroCommandRepo.save(superhero);
    }

    @Override
    public void delete(Long id) {
        Superheroe superheroe = superheroCommandRepo.findById(id).orElseThrow(() -> new SuperheroeNotFoundException("Superheroe not found with the given ID"));
        superheroCommandRepo.delete(superheroe);
    }
}