package org.example.grandao.controller;
import jakarta.validation.Valid;
import org.example.grandao.dtos.Partido;
import org.example.grandao.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The type Partido controller.
 *
 * @deprecated
 */
@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    /**
     * Instantiates a new Partido controller.
     *
     * @param partidoService the partido service
     */
    @Autowired
    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    /**
     * Gets partidos.
     *
     * @return the partidos
     */
    @GetMapping
    public ResponseEntity<List<Partido>> getPartidos() {
        try {
            return ResponseEntity.ok(partidoService.getPartidos());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Gets partido by id.
     *
     * @param id the id
     * @return the partido by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(partidoService.getPartidoById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Create partido response entity.
     *
     * @param partido the partido
     * @return the response entity
     */
    @PostMapping("partido")
    public ResponseEntity<Partido> createPartido(@Valid @RequestBody Partido partido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoService.createPartido(partido));
    }

    /**
     * Update partido response entity.
     *
     * @param id      the id
     * @param partido the partido
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Integer id, @Valid @RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.updatePartido(id, partido));
    }

    /**
     * Delete partido response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Integer id) {
        try {
            partidoService.deletePartido(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
