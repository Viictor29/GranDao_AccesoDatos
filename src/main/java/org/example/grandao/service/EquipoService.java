package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Equipo service.
 *
 * @deprecated
 */
@Service
@CacheConfig(cacheNames = {"equipo"})
public class EquipoService {

    /**
     * The Equipo repository.
     */
    EquipoRepository equipoRepository;

    /**
     * Instantiates a new Equipo service.
     *
     * @param equipoRepository the equipo repository
     */
    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    /**
     * Gets equipos.
     *
     * @return the equipos
     */
    public List<Equipo> getEquipos() {
        return equipoRepository.findAll();
    }

    /**
     * Gets equipo by id.
     *
     * @param id the id
     * @return the equipo by id
     */
    public Equipo getEquipoById(int id) {
        return equipoRepository.findById(id).get();
    }

    /**
     * Create equipo equipo.
     *
     * @param equipo the equipo
     * @return the equipo
     */
    public Equipo createEquipo(Equipo equipo) {
        LocalDate fechaActual = LocalDate.now();

        if(equipo.getFechaFundacion().isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de fundación debe ser anterior a la fecha actual");
        }

        return equipoRepository.save(equipo);
    }

    /**
     * Update equipo equipo.
     *
     * @param id     the id
     * @param equipo the equipo
     * @return the equipo
     */
    public Equipo updateEquipo(Integer id, Equipo equipo) {
        LocalDate fechaActual = LocalDate.now();

        if(equipo.getFechaFundacion().isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de fundación debe ser anterior a la fecha actual");
        }

        Equipo equipoActualizado = equipoRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el equipo con id: " + id));
        equipoActualizado.setNombre(equipo.getNombre());
        equipoActualizado.setEntrenador(equipo.getEntrenador());
        equipoActualizado.setFechaFundacion(equipo.getFechaFundacion());
        return equipoRepository.save(equipoActualizado);
    }

    /**
     * Delete equipo.
     *
     * @param id the id
     */
    public void deleteEquipo(int id) {
        equipoRepository.deleteById(id);
    }
}
