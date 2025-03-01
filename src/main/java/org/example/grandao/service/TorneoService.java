package org.example.grandao.service;

import org.example.grandao.dtos.Torneo;
import org.example.grandao.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Torneo service.
 *
 * @deprecated
 */
@Service
public class TorneoService {
    private final TorneoRepository torneoRepository;

    /**
     * Instantiates a new Torneo service.
     *
     * @param torneoRepository the torneo repository
     */
    @Autowired
    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    /**
     * Gets torneos.
     *
     * @return the torneos
     */
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
        return torneoRepository.findById(id).get();
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
        Torneo torneoActualizado = torneoRepository.findById(id).get();

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
}
