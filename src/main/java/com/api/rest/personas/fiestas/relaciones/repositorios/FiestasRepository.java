package com.api.rest.personas.fiestas.relaciones.repositorios;

import com.api.rest.personas.fiestas.relaciones.entidades.Fiesta;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface FiestasRepository extends CrudRepository<Fiesta, Long> {
    Collection<Fiesta> findAll();
}
