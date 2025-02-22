package org.example.grandao.service;

import org.example.grandao.dtos.Torneo;
import org.example.grandao.repository.TorneoRepository;

import java.util.List;

public class TorneoService {
    private final TorneoRepository torneoRepository;

    public TorneoService(TorneoRepository torneoRepository) {
        this.torneoRepository = torneoRepository;
    }

    public List<Torneo> getTorneos() {
        return torneoRepository.findAll();
    }

    public Torneo getTorneoById(int id) {
        return torneoRepository.findById(id).get();
    }

    public Torneo createTorneo(Torneo torneo) {
        return torneoRepository.save(torneo);
    }

    public Torneo updateTorneo(Torneo torneo) {
        return torneoRepository.save(torneo);
    }

    public void deleteTorneo(int id) {
        torneoRepository.deleteById(id);
    }
}
