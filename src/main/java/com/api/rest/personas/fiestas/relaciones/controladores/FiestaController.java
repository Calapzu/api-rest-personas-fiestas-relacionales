package com.api.rest.personas.fiestas.relaciones.controladores;

import com.api.rest.personas.fiestas.relaciones.entidades.Fiesta;
import com.api.rest.personas.fiestas.relaciones.entidades.Persona;
import com.api.rest.personas.fiestas.relaciones.repositorios.FiestasRepository;
import com.api.rest.personas.fiestas.relaciones.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/fiestas")
public class FiestaController {
    @Autowired
    private FiestasRepository fiestasRepository;

    @GetMapping
    public ResponseEntity<Collection<Fiesta>> listarFiesta() {
        return new ResponseEntity<>(fiestasRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fiesta> obtenerFiestaPorId(@PathVariable long id){
        Fiesta fiesta = fiestasRepository.findById(id).orElseThrow(()->new RuntimeException());

        if (fiesta!= null){
            return new ResponseEntity<>(fiestasRepository.findById(id).orElseThrow(()->new RuntimeException()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> guadarFiesta(@RequestBody Fiesta fiesta){
        return new ResponseEntity<>(fiestasRepository.save(fiesta), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFiesta(@PathVariable long id){
        fiestasRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
