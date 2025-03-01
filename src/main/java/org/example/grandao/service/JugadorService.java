package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.Jugador;
import org.example.grandao.repository.EquipoRepository;
import org.example.grandao.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Jugador service.
 *
 * @deprecated
 */
@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;
    private final EquipoService equipoService;

    /**
     * Instantiates a new Jugador service.
     *
     * @param jugadorRepository the jugador repository
     * @param equipoRepository  the equipo repository
     * @param equipoService     the equipo service
     */
    @Autowired
    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository, EquipoService equipoService) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
        this.equipoService = equipoService;
    }

    /**
     * Gets jugadores.
     *
     * @return the jugadores
     */
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
        return jugadorRepository.findById(id).get();
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
        Jugador jugadorActualizado = jugadorRepository.findById(id).orElseThrow(()-> new RuntimeException("Jugador con id " + id + " no encontrado"));
        jugadorActualizado.setNombre(jugador.getNombre());
        jugadorActualizado.setEdad(jugador.getEdad());
        jugadorActualizado.setPosicion(jugador.getPosicion());

        Equipo equipo = equipoRepository.findById(jugador.getEquipo().getId()).get();
        jugadorActualizado.setEquipo(equipo);

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
}
