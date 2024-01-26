package com.pruebaTecnica.andrea.superheroes.domain.repo;


import com.pruebaTecnica.andrea.superheroes.domain.model.Superheroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SuperheroeCommandRepo extends JpaRepository<Superheroe, Long> {

    List<Superheroe> findByNameContains(String name);
}