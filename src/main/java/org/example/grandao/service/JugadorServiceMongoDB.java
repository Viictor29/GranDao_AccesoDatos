package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.EquipoMongoDB;
import org.example.grandao.dtos.Jugador;
import org.example.grandao.dtos.JugadorMongoDB;
import org.example.grandao.repository.EquipoRepositoryMongoDB;
import org.example.grandao.repository.JugadorRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorServiceMongoDB {
    private final EquipoRepositoryMongoDB equipoRepositoryMongoDB;
    private JugadorRepositoryMongoDB jugadorRepositoryMongoDB;

    @Autowired
    public JugadorServiceMongoDB(JugadorRepositoryMongoDB jugadorRepositoryMongoDB, EquipoRepositoryMongoDB equipoRepositoryMongoDB) {
        this.jugadorRepositoryMongoDB = jugadorRepositoryMongoDB;
        this.equipoRepositoryMongoDB = equipoRepositoryMongoDB;
    }


    public List<JugadorMongoDB> getJugadores() {
        return jugadorRepositoryMongoDB.findAll();
    }

    public JugadorMongoDB getJugadorById(String id) {
        return jugadorRepositoryMongoDB.findById(id).get();
    }

    public JugadorMongoDB createJugador(JugadorMongoDB jugadorMongoDB) {
        return jugadorRepositoryMongoDB.save(jugadorMongoDB);
    }

    public JugadorMongoDB updateJugador(String id, JugadorMongoDB jugador) {
        JugadorMongoDB jugadorActualizado = jugadorRepositoryMongoDB.findById(id).orElseThrow(() -> new RuntimeException("Jugador con id " + id + " no encontrado"));

        jugadorActualizado.setNombre(jugador.getNombre());
        jugadorActualizado.setEdad(jugador.getEdad());
        jugadorActualizado.setPosicion(jugador.getPosicion());

        EquipoMongoDB equipoMongoDB = equipoRepositoryMongoDB.findById(String.valueOf(jugador.getEquipo().getId())).orElseThrow(() -> new RuntimeException("Equipo con id " + jugador.getEquipo().getId() + " no encontrado"));
        jugadorActualizado.setEquipo(equipoMongoDB);

        // Guardar el jugador actualizado en la base de datos
        return jugadorRepositoryMongoDB.save(jugadorActualizado);
    }

    public void deleteJugador(String id) {
        jugadorRepositoryMongoDB.deleteById(id);
    }
}
