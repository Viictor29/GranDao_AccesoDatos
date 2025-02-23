package org.example.grandao.service;

import org.example.grandao.dtos.*;
import org.example.grandao.repository.EquipoRepositoryMongoDB;
import org.example.grandao.repository.PartidoRepositoryMongoDB;
import org.example.grandao.repository.TorneoRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoServiceMongoDB {

    private final TorneoRepositoryMongoDB torneoRepositoryMongoDB;
    private final EquipoRepositoryMongoDB equipoRepositoryMongoDB;
    private PartidoRepositoryMongoDB partidoRepositoryMongoDB;

    @Autowired
    public PartidoServiceMongoDB(PartidoRepositoryMongoDB partidoRepositoryMongoDB, TorneoRepositoryMongoDB torneoRepositoryMongoDB, EquipoRepositoryMongoDB equipoRepositoryMongoDB) {
        this.partidoRepositoryMongoDB = partidoRepositoryMongoDB;
        this.torneoRepositoryMongoDB = torneoRepositoryMongoDB;
        this.equipoRepositoryMongoDB = equipoRepositoryMongoDB;
    }

    public List<PartidoMongoDB> getPartidos() {
        return partidoRepositoryMongoDB.findAll();
    }

    public PartidoMongoDB getPartidoById(String id) {
        return partidoRepositoryMongoDB.findById(id).get();
    }

    public PartidoMongoDB createPartido(PartidoMongoDB partido) {
        TorneoMongoDB torneo = torneoRepositoryMongoDB.findById(partido.getTorneo().getId()).orElseThrow(()-> new IllegalArgumentException("No existe torneo"));

        if (partido.getFecha().isBefore(torneo.getFechaInicio()) || partido.getFecha().isAfter(torneo.getFechaFin())){
            throw new IllegalArgumentException("La fecha del partido debe estar entre la fecha de inicio y fin del torneo");
        }
        return partidoRepositoryMongoDB.save(partido);
    }

    public PartidoMongoDB updatePartido(String id, PartidoMongoDB partido) {
        PartidoMongoDB partidoActualizado = partidoRepositoryMongoDB.findById(id).get();

        TorneoMongoDB torneo = torneoRepositoryMongoDB.findById(String.valueOf(partido.getTorneo().getId())).orElseThrow(() -> new RuntimeException("Torneo con id " + partido.getTorneo().getId() + " no encontrado"));

        if (partido.getFecha().isBefore(torneo.getFechaInicio()) || partido.getFecha().isAfter(torneo.getFechaFin())){
            throw new IllegalArgumentException("La fecha del partido debe estar entre la fecha de inicio y fin del torneo");
        }

        partidoActualizado.setFecha(partido.getFecha());
        partidoActualizado.setGolesLocal(partido.getGolesLocal());
        partidoActualizado.setGolesVisitante(partido.getGolesVisitante());

        EquipoMongoDB equipoLocal = equipoRepositoryMongoDB.findById(partido.getEquipoLocal().getId()).get();
        EquipoMongoDB equipoVisitante = equipoRepositoryMongoDB.findById(partido.getEquipoVisitante().getId()).get();

        partidoActualizado.setEquipoLocal(equipoLocal);
        partidoActualizado.setEquipoVisitante(equipoVisitante);


        partidoActualizado.setTorneo(torneo);

        return partidoRepositoryMongoDB.save(partidoActualizado);
    }

    public void deletePartido(String id) {
        partidoRepositoryMongoDB.deleteById(id);
    }
}
