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

/**
 * The type Partido service.
 *
 * @deprecated
 */
@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;
    private final EquipoRepository equipoRepository;
    private final TorneoRepository torneoRepository;

    /**
     * Instantiates a new Partido service.
     *
     * @param partidoRepository the partido repository
     * @param equipoRepository  the equipo repository
     * @param torneoRepository  the torneo repository
     */
    @Autowired
    public PartidoService(PartidoRepository partidoRepository, EquipoRepository equipoRepository, TorneoRepository torneoRepository) {
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
        this.torneoRepository = torneoRepository;
    }

    /**
     * Gets partidos.
     *
     * @return the partidos
     */
    public List<Partido> getPartidos() {
        return partidoRepository.findAll();
    }

    /**
     * Gets partido by id.
     *
     * @param id the id
     * @return the partido by id
     */
    public Partido getPartidoById(int id) {
        return partidoRepository.findById(id).get();
    }

    /**
     * Create partido partido.
     *
     * @param partido the partido
     * @return the partido
     */
    public Partido createPartido(Partido partido) {
        Torneo torneo = torneoRepository.findById(partido.getTorneo().getId()).orElseThrow(()-> new IllegalArgumentException("No existe torneo"));

        if (partido.getFecha().isBefore(torneo.getFechaInicio()) || partido.getFecha().isAfter(torneo.getFechaFin())){
            throw new IllegalArgumentException("La fecha del partido debe estar entre la fecha de inicio y fin del torneo");
        }
            return partidoRepository.save(partido);
    }

    /**
     * Update partido partido.
     *
     * @param id      the id
     * @param partido the partido
     * @return the partido
     */
    public Partido updatePartido(Integer id, Partido partido) {
        Partido partidoActualizado = partidoRepository.findById(id).get();
        Torneo torneo = torneoRepository.findById(partido.getTorneo().getId()).orElseThrow(()-> new IllegalArgumentException("No existe torneo con el id " + id));

        if (partido.getFecha().isBefore(torneo.getFechaInicio()) || partido.getFecha().isAfter(torneo.getFechaFin())){
            throw new IllegalArgumentException("La fecha del partido debe estar entre la fecha de inicio y fin del torneo");
        }

        partidoActualizado.setFecha(partido.getFecha());
        partidoActualizado.setGolesLocal(partido.getGolesLocal());
        partidoActualizado.setGolesVisitante(partido.getGolesVisitante());

        Equipo equipoLocal = equipoRepository.findById(partido.getEquipoLocal().getId()).get();
        Equipo equipoVisitante = equipoRepository.findById(partido.getEquipoVisitante().getId()).get();

        partidoActualizado.setEquipoLocal(equipoLocal);
        partidoActualizado.setEquipoVisitante(equipoVisitante);


        partidoActualizado.setTorneo(torneo);

        return partidoRepository.save(partidoActualizado);
    }

    /**
     * Delete partido.
     *
     * @param id the id
     */
    public void deletePartido(int id) {
        partidoRepository.deleteById(id);
    }
}
