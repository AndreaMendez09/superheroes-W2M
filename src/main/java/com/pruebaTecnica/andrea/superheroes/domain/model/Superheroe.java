package com.pruebaTecnica.andrea.superheroes.domain.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "SUPERHEROES")
public class Superheroe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
    @Column
    String alias;
    @Column
    String power;
    @Column
    String universe;

    public Superheroe(Long id, String name, String alias, String power, String universe) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.power = power;
        this.universe = universe;
    }

    public Superheroe() {
    }

    public Superheroe(String spiderman, String peterParker, String agility, String marvel) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }
}