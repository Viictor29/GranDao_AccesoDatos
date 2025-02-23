package org.example.grandao.controller;
import jakarta.validation.Valid;
import org.example.grandao.dtos.Torneo;
import org.example.grandao.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/torneos")
public class TorneoController {

    private final TorneoService torneoService;

    @Autowired
    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    @GetMapping
    public ResponseEntity<List<Torneo>> getTorneos() {
        try {
            return ResponseEntity.ok(torneoService.getTorneos());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneo> getTorneoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(torneoService.getTorneoById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("torneo")
    public ResponseEntity<Torneo> createTorneo(@Valid @RequestBody Torneo torneo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(torneoService.createTorneo(torneo));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneo> updateTorneo(@PathVariable Integer id, @Valid @RequestBody Torneo torneo) {
        try {
            return ResponseEntity.ok(torneoService.updateTorneo(id, torneo));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTorneo(@PathVariable Integer id) {
        try {
            torneoService.deleteTorneo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
