package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.Partido;
import org.example.grandao.dtos.Torneo;
import org.example.grandao.repository.EquipoRepository;
import org.example.grandao.repository.PartidoRepository;
import org.example.grandao.repository.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;
    private final EquipoRepository equipoRepository;
    private final TorneoRepository torneoRepository;

    @Autowired
    public PartidoService(PartidoRepository partidoRepository, EquipoRepository equipoRepository, TorneoRepository torneoRepository) {
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
        this.torneoRepository = torneoRepository;
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

    public Partido updatePartido(Integer id, Partido partido) {
        Partido partidoActualizado = partidoRepository.findById(id).get();

        partidoActualizado.setFecha(partido.getFecha());
        partidoActualizado.setGolesLocal(partido.getGolesLocal());
        partidoActualizado.setGolesVisitante(partido.getGolesVisitante());

        Equipo equipoLocal = equipoRepository.findById(partido.getEquipoLocal().getId()).get();
        Equipo equipoVisitante = equipoRepository.findById(partido.getEquipoVisitante().getId()).get();

        partidoActualizado.setEquipoLocal(equipoLocal);
        partidoActualizado.setEquipoVisitante(equipoVisitante);

        Torneo torneo = torneoRepository.findById(partido.getTorneo().getId()).get();
        partidoActualizado.setTorneo(torneo);

        return partidoRepository.save(partidoActualizado);
    }

    public void deletePartido(int id) {
        partidoRepository.deleteById(id);
    }
}
