package org.example.grandao.service;

import org.example.grandao.dtos.Jugador;
import org.example.grandao.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
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

    public Jugador updateJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(int id) {
        jugadorRepository.deleteById(id);
    }
}
