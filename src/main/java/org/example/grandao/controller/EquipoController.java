package org.example.grandao.controller;

import jakarta.validation.Valid;
import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.Jugador;
import org.example.grandao.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Integer id) {
        try {
            Equipo equipo = equipoService.getEquipoById(id);
            return ResponseEntity.ok(equipo);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/equipo")
    public ResponseEntity<Equipo> createEquipo(@Valid @RequestBody Equipo equipo) {
        try {
            Equipo equipoPersistido = equipoService.createEquipo(equipo);
            return ResponseEntity.status(HttpStatus.CREATED).body(equipoPersistido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //Todo corregir que se modifique ya que se crea
    @PutMapping("/{id}")
    public ResponseEntity<Equipo> updateEquipo(@Valid @RequestBody Equipo equipo) {
        try {
            Equipo equipoModificado = equipoService.updateEquipo(equipo);
            return ResponseEntity.ok(equipoModificado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
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
