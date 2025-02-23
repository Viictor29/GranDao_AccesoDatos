package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.Jugador;
import org.example.grandao.repository.EquipoRepository;
import org.example.grandao.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final EquipoRepository equipoRepository;
    private final EquipoService equipoService;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository, EquipoRepository equipoRepository, EquipoService equipoService) {
        this.jugadorRepository = jugadorRepository;
        this.equipoRepository = equipoRepository;
        this.equipoService = equipoService;
    }

    public List<Jugador> getJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador getJugadorById(int id) {
        return jugadorRepository.findById(id).get();
    }

    public Jugador createJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador updateJugador(Integer id, Jugador jugador) {
        Jugador jugadorActualizado = jugadorRepository.findById(id).orElseThrow(()-> new RuntimeException("Jugador con id " + id + " no encontrado"));
        jugadorActualizado.setNombre(jugador.getNombre());
        jugadorActualizado.setEdad(jugador.getEdad());
        jugadorActualizado.setPosicion(jugador.getPosicion());

        Equipo equipo = equipoRepository.findById(jugador.getEquipo().getId()).get();
        jugadorActualizado.setEquipo(equipo);

        return jugadorRepository.save(jugadorActualizado);
    }

    public void deleteJugador(int id) {
        jugadorRepository.deleteById(id);
    }
}
