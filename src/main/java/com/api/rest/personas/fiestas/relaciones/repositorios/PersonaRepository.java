package com.api.rest.personas.fiestas.relaciones.repositorios;

import com.api.rest.personas.fiestas.relaciones.entidades.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    Collection<Persona> findAll();
}
