package org.example.grandao.controller;

import jakarta.validation.Valid;
import org.example.grandao.dtos.Jugador;
import org.example.grandao.service.EquipoService;
import org.example.grandao.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }



    @GetMapping
    public ResponseEntity<List<Jugador>> getJugadores() {
        try {
            List<Jugador> jugadores = jugadorService.getJugadores();
            return ResponseEntity.ok(jugadores);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> getJugadorById(@PathVariable Integer id) {
        try {
            Jugador jugador = jugadorService.getJugadorById(id);
            return ResponseEntity.ok(jugador);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("jugador")
    public ResponseEntity<Jugador> createJugador(@Valid @RequestBody Jugador jugador) {
        try {
            Jugador jugadorPersistido = jugadorService.createJugador(jugador);
            return ResponseEntity.status(HttpStatus.CREATED).body(jugadorPersistido);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateJugador(@Valid @RequestBody Jugador jugador) {
        try {
            Jugador jugadorModificado = jugadorService.updateJugador(jugador);
            return ResponseEntity.ok(jugadorModificado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jugador> deleteJugador(@PathVariable Integer id) {
        try {
            jugadorService.deleteJugador(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
