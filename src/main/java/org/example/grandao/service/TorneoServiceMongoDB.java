package org.example.grandao.service;

import org.example.grandao.dtos.Torneo;
import org.example.grandao.dtos.TorneoMongoDB;
import org.example.grandao.repository.TorneoRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoServiceMongoDB {

    private TorneoRepositoryMongoDB torneoRepositoryMongoDB;

    @Autowired
    public TorneoServiceMongoDB(TorneoRepositoryMongoDB torneoRepositoryMongoDB) {
        this.torneoRepositoryMongoDB = torneoRepositoryMongoDB;
    }

    public List<TorneoMongoDB> getTorneos() {
        return torneoRepositoryMongoDB.findAll();
    }

    public TorneoMongoDB getTorneoById(String id) {
        return torneoRepositoryMongoDB.findById(id).get();
    }

    public TorneoMongoDB createTorneo(TorneoMongoDB torneo) {
        return torneoRepositoryMongoDB.save(torneo);
    }

    public TorneoMongoDB updateTorneo(String id, TorneoMongoDB torneo) {
        TorneoMongoDB torneoActualizado = torneoRepositoryMongoDB.findById(id).get();

        torneoActualizado.setNombre(torneo.getNombre());
        torneoActualizado.setFechaInicio(torneo.getFechaInicio());
        torneoActualizado.setFechaFin(torneo.getFechaFin());
        torneoActualizado.setUbicacion(torneo.getUbicacion());

        return torneoRepositoryMongoDB.save(torneoActualizado);
    }

    public void deleteTorneo(String id) {
        torneoRepositoryMongoDB.deleteById(id);
    }
}
