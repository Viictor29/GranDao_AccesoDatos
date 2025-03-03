package org.example.grandao.controller;

import jakarta.validation.Valid;
import org.example.grandao.dtos.*;
import org.example.grandao.service.GranDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.JAXBException;

import java.util.List;

/**
 * Controlador global de la API.
 */
@RestController
@RequestMapping("/api")
public class GranDaoController {

    private final GranDaoService granDaoService;

    /**
     * Instantiates a new Controller.
     *
     * @param granDaoService the gran dao service
     */
    @Autowired
    public GranDaoController(GranDaoService granDaoService) {
        this.granDaoService = granDaoService;
    }

    /**
     * Gets equipos.
     *
     * @return the equipos
     */
// ****************** EQUIPOS SQL ******************
    @GetMapping("/equipos")
    public ResponseEntity<List<Equipo>> getEquipos() {
        return ResponseEntity.ok(granDaoService.getEquipos());
    }

    /**
     * Gets equipo by id.
     *
     * @param id the id
     * @return the equipo by id
     */
    @GetMapping("/equipos/{id}")
    public ResponseEntity<Equipo> getEquipoById(@PathVariable Integer id) {
        return ResponseEntity.ok(granDaoService.getEquipoById(id));
    }

    /**
     * Create equipo response entity.
     *
     * @param equipo the equipo
     * @return the response entity
     */
    @PostMapping("/equipos")
    public ResponseEntity<Equipo> createEquipo(@Valid @RequestBody Equipo equipo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(granDaoService.createEquipo(equipo));
    }

    /**
     * Update equipo response entity.
     *
     * @param id     the id
     * @param equipo the equipo
     * @return the response entity
     */
    @PutMapping("/equipos/{id}")
    public ResponseEntity<Equipo> updateEquipo(@PathVariable Integer id, @Valid @RequestBody Equipo equipo) {
        return ResponseEntity.ok(granDaoService.updateEquipo(id, equipo));
    }

    /**
     * Delete equipo response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Integer id) {
        granDaoService.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Gets jugadores.
     *
     * @return the jugadores
     */
// ****************** JUGADORES SQL******************
    @GetMapping("/jugadores")
    public ResponseEntity<List<Jugador>> getJugadores() {
        return ResponseEntity.ok(granDaoService.getJugadores());
    }

    /**
     * Gets jugador by id.
     *
     * @param id the id
     * @return the jugador by id
     */
    @GetMapping("/jugadores/{id}")
    public ResponseEntity<Jugador> getJugadorById(@PathVariable Integer id) {
        return ResponseEntity.ok(granDaoService.getJugadorById(id));
    }

    /**
     * Create jugador response entity.
     *
     * @param jugador the jugador
     * @return the response entity
     */
    @PostMapping("/jugadores")
    public ResponseEntity<Jugador> createJugador(@Valid @RequestBody Jugador jugador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(granDaoService.createJugador(jugador));
    }

    /**
     * Update jugador response entity.
     *
     * @param id      the id
     * @param jugador the jugador
     * @return the response entity
     */
    @PutMapping("/jugadores/{id}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable Integer id, @Valid @RequestBody Jugador jugador) {
        return ResponseEntity.ok(granDaoService.updateJugador(id, jugador));
    }

    /**
     * Delete jugador response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/jugadores/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Integer id) {
        granDaoService.deleteJugador(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Gets partidos.
     *
     * @return the partidos
     */
// ****************** PARTIDOS SQL******************
    @GetMapping("/partidos")
    public ResponseEntity<List<Partido>> getPartidos() {
        return ResponseEntity.ok(granDaoService.getPartidos());
    }

    /**
     * Gets partido by id.
     *
     * @param id the id
     * @return the partido by id
     */
    @GetMapping("/partidos/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Integer id) {
        return ResponseEntity.ok(granDaoService.getPartidoById(id));
    }

    /**
     * Create partido response entity.
     *
     * @param partido the partido
     * @return the response entity
     */
    @PostMapping("/partidos")
    public ResponseEntity<Partido> createPartido(@Valid @RequestBody Partido partido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(granDaoService.createPartido(partido));
    }

    /**
     * Update partido response entity.
     *
     * @param id      the id
     * @param partido the partido
     * @return the response entity
     */
    @PutMapping("/partidos/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Integer id, @Valid @RequestBody Partido partido) {
        return ResponseEntity.ok(granDaoService.updatePartido(id, partido));
    }

    /**
     * Delete partido response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/partidos/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Integer id) {
        granDaoService.deletePartido(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Gets torneos.
     *
     * @return the torneos
     */
// ****************** TORNEOS SQL******************
    @GetMapping("/torneos")
    public ResponseEntity<List<Torneo>> getTorneos() {
        return ResponseEntity.ok(granDaoService.getTorneos());
    }

    /**
     * Gets torneo by id.
     *
     * @param id the id
     * @return the torneo by id
     */
    @GetMapping("/torneos/{id}")
    public ResponseEntity<Torneo> getTorneoById(@PathVariable Integer id) {
        return ResponseEntity.ok(granDaoService.getTorneoById(id));
    }

    /**
     * Create torneo response entity.
     *
     * @param torneo the torneo
     * @return the response entity
     */
    @PostMapping("/torneos")
    public ResponseEntity<Torneo> createTorneo(@Valid @RequestBody Torneo torneo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(granDaoService.createTorneo(torneo));
    }

    /**
     * Update torneo response entity.
     *
     * @param id id del torneo
     * @param torneo el torneo
     * @return the response entity
     */
    @PutMapping("/torneos/{id}")
    public ResponseEntity<Torneo> updateaTorneo(@PathVariable Integer id, @Valid @RequestBody Torneo torneo) {
        return ResponseEntity.ok(granDaoService.updateTorneo(id, torneo));
    }

    /**
     * Delete torneo response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/torneos/{id}")
    public ResponseEntity<Void> deleteTorneo(@PathVariable Integer id) {
        granDaoService.deleteTorneo(id);
        return ResponseEntity.noContent().build();
    }

// ****************** COCHES XML******************

    @GetMapping("/coches")
    public ResponseEntity<CochesList> getCoches() throws JAXBException {
        List<Coche> coches = granDaoService.getCoches();  // Obtienes la lista de coches
        CochesList cochesList = new CochesList(coches);  // La envuelves en un CochesList
        return ResponseEntity.ok(cochesList);  // Devuelves el objeto CochesList
    }

    //GET COCHE BY MATRICULA
    @GetMapping("/coches/{matricula}")
    public ResponseEntity<Coche> obtenerCocheByMatricula(@PathVariable String matricula) throws JAXBException {
        // Llama al Service para obtener el coche por su matrícula
        Coche coche = granDaoService.obtenerCocheByMatricula(matricula);
        if (coche != null) {
            return ResponseEntity.ok(coche);
        } else {
            return ResponseEntity.notFound().build();  // Si no se encuentra el coche, responde con 404 Not Found
        }
    }

    @PostMapping("/coches")
    public ResponseEntity<Coche> postCoche(@RequestBody @Valid Coche coche) throws JAXBException {
        granDaoService.guardarCoche(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(coche);
    }

// ****************** PRODUCTOS TXT******************

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(granDaoService.obtenerTodos());
    }


    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable int id) {
        Producto producto = granDaoService.obtenerPorId(id);
        return producto != null ? ResponseEntity.ok(producto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/productos")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        granDaoService.agregarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto guardado correctamente.");
    }

// ****************** PRODUCTO MONGO******************

    @GetMapping("/productosMongo")
    public ResponseEntity<List<ProductoMongo>> obtenerTodasLasCiudades() {
        return ResponseEntity.ok(granDaoService.getAllProductosMongo());
    }


    @GetMapping("/productosMongo/{id}")
    public ResponseEntity<ProductoMongo> getProductoById(@PathVariable String id) {
        return ResponseEntity.ok(granDaoService.getProductoByIdMongo(id));
    }


    @PostMapping("/productosMongo")
    public ResponseEntity<ProductoMongo> saveProducto(@RequestBody ProductoMongo productoMongo) {
        return ResponseEntity.ok(granDaoService.saveProductoMongo(productoMongo));
    }

    @PutMapping("productosMongo/{id}")
    public ResponseEntity<ProductoMongo> actualizarProducto(@PathVariable String id, @RequestBody ProductoMongo productoMongo) {
        productoMongo.setId(id); // Asegurar que el ID coincida
        return ResponseEntity.ok().body(granDaoService.saveProductoMongo(productoMongo));
    }


    @DeleteMapping("/productosMongo/{id}")
    public ResponseEntity<String> deleteProducto(@PathVariable String id) {
        granDaoService.deleteProductoMongo(id);
        return ResponseEntity.noContent().build();
    }
}
