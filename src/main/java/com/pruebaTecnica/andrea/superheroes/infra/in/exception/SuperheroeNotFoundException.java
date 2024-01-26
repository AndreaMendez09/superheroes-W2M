package com.pruebaTecnica.andrea.superheroes.infra.in.exception;

public class SuperheroeNotFoundException extends RuntimeException{
    public SuperheroeNotFoundException(String message){
        super(message);
    }
}