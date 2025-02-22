package org.example.grandao.service;

import org.example.grandao.dtos.Torneo;
import org.example.grandao.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneoService {
    private final TorneoRepository torneoRepository;

    @Autowired
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
