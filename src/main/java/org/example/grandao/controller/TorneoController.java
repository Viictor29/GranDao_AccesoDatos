package org.example.grandao.controller;
import jakarta.validation.Valid;
import org.example.grandao.dtos.Torneo;
import org.example.grandao.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * The type Torneo controller.
 *
 * @deprecated
 */
@RestController
@RequestMapping("/torneos")
public class TorneoController {

    private final TorneoService torneoService;

    /**
     * Instantiates a new Torneo controller.
     *
     * @param torneoService the torneo service
     */
    @Autowired
    public TorneoController(TorneoService torneoService) {
        this.torneoService = torneoService;
    }

    /**
     * Gets torneos.
     *
     * @return the torneos
     */
    @GetMapping
    public ResponseEntity<List<Torneo>> getTorneos() {
        try {
            return ResponseEntity.ok(torneoService.getTorneos());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Gets torneo by id.
     *
     * @param id the id
     * @return the torneo by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Torneo> getTorneoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(torneoService.getTorneoById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create torneo response entity.
     *
     * @param torneo the torneo
     * @return the response entity
     */
    @PostMapping("torneo")
    public ResponseEntity<Torneo> createTorneo(@Valid @RequestBody Torneo torneo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(torneoService.createTorneo(torneo));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Update torneo response entity.
     *
     * @param id     the id
     * @param torneo the torneo
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Torneo> updateTorneo(@PathVariable Integer id, @Valid @RequestBody Torneo torneo) {
        try {
            return ResponseEntity.ok(torneoService.updateTorneo(id, torneo));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Delete torneo response entity.
     *
     * @param id the id
     * @return the response entity
     */
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
