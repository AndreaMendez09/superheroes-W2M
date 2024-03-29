package com.pruebaTecnica.andrea.superheroes.infra.in.web;

import com.pruebaTecnica.andrea.superheroes.app.service.SuperheroeAction;
import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/superheroes")
public class SuperheroeController {

    private final SuperheroeAction superheroService;

    public SuperheroeController(SuperheroeAction superheroService) {
        this.superheroService = superheroService;
    }

    @GetMapping
    public ResponseEntity<List<Superheroe>> retrieveAll() {
        List<Superheroe> superheroes = superheroService.retrieveAll();
        return ResponseEntity.ok(superheroes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superheroe> retrieveById(@PathVariable Long id) {
        return ResponseEntity.ok(superheroService.retrieveById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Superheroe>> retrieveByName(@PathVariable String name) {
        return ResponseEntity.ok(superheroService.retrieveByName(name));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Superheroe superhero) {
        superheroService.create(superhero);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Superheroe superhero) {
        superheroService.update(id,superhero);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperhero(@PathVariable Long id) {
        superheroService.delete(id);
        return ResponseEntity.ok().build();
    }
}
