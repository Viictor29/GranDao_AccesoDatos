package org.example.grandao.controller;

import jakarta.validation.Valid;
import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.Jugador;
import org.example.grandao.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private EquipoService equipoService;

    @Autowired
    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }


    @GetMapping
    public ResponseEntity<List<Equipo>> getEquipos() {
        try {
            List<Equipo> equipos =equipoService.getEquipos();
            return ResponseEntity.ok(equipos);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Cacheable
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Integer id) {
        try {
            Equipo equipo = equipoService.getEquipoById(id);
            return ResponseEntity.ok(equipo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Equipo> createEquipo(@Valid @RequestBody Equipo equipo) {
        Equipo equipoPersistido = equipoService.createEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(equipoPersistido);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Integer id, @Valid @RequestBody Equipo equipo) {
        Equipo equipoModificado = equipoService.updateEquipo(id, equipo);
        return ResponseEntity.ok(equipoModificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipo> deleteEquipo(@PathVariable Integer id) {
        try {
            equipoService.deleteEquipo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
