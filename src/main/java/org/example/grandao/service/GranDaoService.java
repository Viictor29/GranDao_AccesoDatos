package org.example.grandao.service;

import jakarta.validation.Valid;
import org.example.grandao.daos.CocheXML;
import org.example.grandao.daos.ProductoTXT;
import org.example.grandao.dtos.*;
import org.example.grandao.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Gran dao service.
 */
@Service
@CacheConfig(cacheNames = {"granDao"})
public class GranDaoService {

    private final EquipoRepository equipoRepository;
    private final JugadorRepository jugadorRepository;
    private final PartidoRepository partidoRepository;
    private final TorneoRepository torneoRepository;
    private final CocheXML cocheRepository;
    private final ProductoTXT productoTxt;
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    /**
     * Instantiates a new Gran dao service.
     *
     * @param equipoRepository  the equipo repository
     * @param jugadorRepository the jugador repository
     * @param partidoRepository the partido repository
     * @param torneoRepository  the torneo repository
     * @param productoRepository the productoMongoDB repository
     * @param pedidoRepository the pedidoMongoDB repository
     * @param cocheRepository the coche Repository
     */
    @Autowired
    public GranDaoService(EquipoRepository equipoRepository, JugadorRepository jugadorRepository,
                          PartidoRepository partidoRepository, TorneoRepository torneoRepository, CocheXML cocheRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository) {
        this.equipoRepository = equipoRepository;
        this.jugadorRepository = jugadorRepository;
        this.partidoRepository = partidoRepository;
        this.torneoRepository = torneoRepository;
        this.cocheRepository = cocheRepository;
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
        this.productoTxt = new ProductoTXT();
    }

    /**
     * Gets equipos.
     *
     * @return the equipos
     */
// ****************** EQUIPOS SQL ******************
    public List<Equipo> getEquipos() {
        return equipoRepository.findAll();
    }

    /**
     * Gets equipo by id.
     *
     * @param id the id
     * @return the equipo by id
     */
    public Equipo getEquipoById(int id) {
        return equipoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    /**
     * Create equipo equipo.
     *
     * @param equipo the equipo
     * @return the equipo
     */
    public Equipo createEquipo(Equipo equipo) {
        if (equipo.getFechaFundacion().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de fundación debe ser anterior a la fecha actual");
        }
        return equipoRepository.save(equipo);
    }

    /**
     * Update equipo equipo.
     *
     * @param id     the id
     * @param equipo the equipo
     * @return the equipo
     */
    public Equipo updateEquipo(Integer id, Equipo equipo) {
        Equipo equipoActualizado = getEquipoById(id);
        equipoActualizado.setNombre(equipo.getNombre());
        equipoActualizado.setEntrenador(equipo.getEntrenador());
        equipoActualizado.setFechaFundacion(equipo.getFechaFundacion());
        return equipoRepository.save(equipoActualizado);
    }

    /**
     * Delete equipo.
     *
     * @param id the id
     */
    public void deleteEquipo(int id) {
        equipoRepository.deleteById(id);
    }

    /**
     * Gets jugadores.
     *
     * @return the jugadores
     */
// ****************** JUGADORES SQL ******************
    public List<Jugador> getJugadores() {
        return jugadorRepository.findAll();
    }

    /**
     * Gets jugador by id.
     *
     * @param id the id
     * @return the jugador by id
     */
    public Jugador getJugadorById(int id) {
        return jugadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
    }

    /**
     * Create jugador jugador.
     *
     * @param jugador the jugador
     * @return the jugador
     */
    public Jugador createJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    /**
     * Update jugador jugador.
     *
     * @param id      the id
     * @param jugador the jugador
     * @return the jugador
     */
    public Jugador updateJugador(Integer id, Jugador jugador) {
        Jugador jugadorActualizado = getJugadorById(id);
        jugadorActualizado.setNombre(jugador.getNombre());
        jugadorActualizado.setEdad(jugador.getEdad());
        jugadorActualizado.setPosicion(jugador.getPosicion());
        jugadorActualizado.setEquipo(getEquipoById(jugador.getEquipo().getId()));
        return jugadorRepository.save(jugadorActualizado);
    }

    /**
     * Delete jugador.
     *
     * @param id the id
     */
    public void deleteJugador(int id) {
        jugadorRepository.deleteById(id);
    }

    /**
     * Gets partidos.
     *
     * @return the partidos
     */
// ****************** PARTIDOS SQL ******************
    public List<Partido> getPartidos() {
        return partidoRepository.findAll();
    }

    /**
     * Gets partido by id.
     *
     * @param id the id
     * @return the partido by id
     */
    public Partido getPartidoById(int id) {
        return partidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Partido no encontrado"));
    }

    /**
     * Create partido partido.
     *
     * @param partido the partido
     * @return the partido
     */
    public Partido createPartido(Partido partido) {
        Torneo torneo = torneoRepository.findById(partido.getTorneo().getId())
                .orElseThrow(() -> new IllegalArgumentException("No existe el torneo"));
        if (partido.getFecha().isBefore(torneo.getFechaInicio()) || partido.getFecha().isAfter(torneo.getFechaFin())) {
            throw new IllegalArgumentException("La fecha del partido debe estar entre la fecha de inicio y fin del torneo");
        }
        return partidoRepository.save(partido);
    }

    /**
     * Update partido partido.
     *
     * @param id      the id
     * @param partido the partido
     * @return the partido
     */
    public Partido updatePartido(Integer id, Partido partido) {
        Partido partidoActualizado = getPartidoById(id);
        Torneo torneo = torneoRepository.findById(partido.getTorneo().getId())
                .orElseThrow(() -> new IllegalArgumentException("No existe el torneo con el id " + id));
        if (partido.getFecha().isBefore(torneo.getFechaInicio()) || partido.getFecha().isAfter(torneo.getFechaFin())) {
            throw new IllegalArgumentException("La fecha del partido debe estar entre la fecha de inicio y fin del torneo");
        }
        partidoActualizado.setFecha(partido.getFecha());
        partidoActualizado.setGolesLocal(partido.getGolesLocal());
        partidoActualizado.setGolesVisitante(partido.getGolesVisitante());
        partidoActualizado.setEquipoLocal(getEquipoById(partido.getEquipoLocal().getId()));
        partidoActualizado.setEquipoVisitante(getEquipoById(partido.getEquipoVisitante().getId()));
        partidoActualizado.setTorneo(torneo);
        return partidoRepository.save(partidoActualizado);
    }

    /**
     * Delete partido.
     *
     * @param id the id
     */
    public void deletePartido(int id) {
        partidoRepository.deleteById(id);
    }

    /**
     * Gets torneos.
     *
     * @return the torneos
     */
// ****************** TORNEOS SQL ******************
    public List<Torneo> getTorneos() {
        return torneoRepository.findAll();
    }

    /**
     * Gets torneo by id.
     *
     * @param id the id
     * @return the torneo by id
     */
    public Torneo getTorneoById(int id) {
        return torneoRepository.findById(id).orElseThrow(() -> new RuntimeException("Torneo no encontrado"));
    }

    /**
     * Create torneo torneo.
     *
     * @param torneo the torneo
     * @return the torneo
     */
    public Torneo createTorneo(Torneo torneo) {
        return torneoRepository.save(torneo);
    }

    /**
     * Update torneo torneo.
     *
     * @param id     the id
     * @param torneo the torneo
     * @return the torneo
     */
    public Torneo updateTorneo(Integer id, Torneo torneo) {
        Torneo torneoActualizado = getTorneoById(id);
        torneoActualizado.setNombre(torneo.getNombre());
        torneoActualizado.setFechaInicio(torneo.getFechaInicio());
        torneoActualizado.setFechaFin(torneo.getFechaFin());
        torneoActualizado.setUbicacion(torneo.getUbicacion());
        return torneoRepository.save(torneoActualizado);
    }

    /**
     * Delete torneo.
     *
     * @param id the id
     */
    public void deleteTorneo(int id) {
        torneoRepository.deleteById(id);
    }

    // ****************** COCHES XML ******************

    public List<Coche> getCoches() throws JAXBException{
        return cocheRepository.leerCoches();
    }

    public Coche obtenerCocheByMatricula(String matricula) throws JAXBException {
        List<Coche> listaCoches = cocheRepository.leerCochesPorMarca(matricula);

        for (Coche coche : listaCoches) {
            if (coche.getMarca().equals(matricula)) {
                return coche;
            }
        }
        return null;
    }

    public void guardarCoche(@Valid Coche coche) throws JAXBException {
        List<Coche> coches = getCoches();
        if (coches == null) {
            coches = new ArrayList<>();
        }
        coches.add(coche);  // Agrega el coche
        cocheRepository.guardarCoches(coches);  // Guarda la lista actualizada
    }

    // ********************* PRODUCTOS TXT *****************

    public List<Producto> obtenerTodos() {
        return productoTxt.leerProductos();
    }

    public Producto obtenerPorId(int id) {
        return productoTxt.buscarPorId(id);
    }

    public void agregarProducto(Producto producto) {
        productoTxt.guardarProducto(producto);
    }

    // ********************* PRODUCTO MONGODB *****************

    public List<Producto> getAllProductosMongo() {
        return productoRepository.findAll();
    }

    public Producto getProductoByIdMongo(String id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto saveProductoMongo(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProductoMongo(String id) {
        productoRepository.deleteById(id);
    }

    // ********************* PEDIDO MONGODB *****************

    public List<Pedido> getAllPedidosMongo() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoByIdMongo(String id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public Pedido savePedidoMongo(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletePedidoMongo(String id) {
        pedidoRepository.deleteById(id);
    }
}
