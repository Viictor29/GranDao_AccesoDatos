package org.example.grandao.service;

import org.example.grandao.dtos.Partido;
import org.example.grandao.repository.PartidoRepository;

import java.util.List;

public class PartidoService {

    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> getPartidos() {
        return partidoRepository.findAll();
    }

    public Partido getPartidoById(int id) {
        return partidoRepository.findById(id).get();
    }

    public Partido createPartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public Partido updatePartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deletePartido(int id) {
        partidoRepository.deleteById(id);
    }
}
