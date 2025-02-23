package org.example.grandao.controller;
import jakarta.validation.Valid;
import org.example.grandao.dtos.Partido;
import org.example.grandao.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    @Autowired
    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public ResponseEntity<List<Partido>> getPartidos() {
        try {
            return ResponseEntity.ok(partidoService.getPartidos());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(partidoService.getPartidoById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("partido")
    public ResponseEntity<Partido> createPartido(@Valid @RequestBody Partido partido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(partidoService.createPartido(partido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Integer id, @Valid @RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.updatePartido(id, partido));
    }

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
