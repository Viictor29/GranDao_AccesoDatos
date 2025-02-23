package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.dtos.EquipoMongoDB;
import org.example.grandao.repository.EquipoRepository;
import org.example.grandao.repository.EquipoRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EquipoServiceMongoDB {
    EquipoRepositoryMongoDB equipoRepositoryMongoDB;

    @Autowired
    public EquipoServiceMongoDB(EquipoRepositoryMongoDB equipoRepositoryMongoDB) {
        this.equipoRepositoryMongoDB = equipoRepositoryMongoDB;
    }


    public List<EquipoMongoDB> getEquipos() {
        return equipoRepositoryMongoDB.findAll();
    }

    public EquipoMongoDB getEquipoById(String id) {
        return equipoRepositoryMongoDB.findById(id).get();
    }

    public EquipoMongoDB createEquipo(EquipoMongoDB equipo) {
        LocalDate fechaActual = LocalDate.now();

        if(equipo.getFechaFundacion().isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de fundación debe ser anterior a la fecha actual");
        }
        return equipoRepositoryMongoDB.save(equipo);
    }

    public EquipoMongoDB updateEquipo(String id, EquipoMongoDB equipo) {
        LocalDate fechaActual = LocalDate.now();

        if(equipo.getFechaFundacion().isAfter(fechaActual)) {
            throw new IllegalArgumentException("La fecha de fundación debe ser anterior a la fecha actual");
        }

        EquipoMongoDB equipoActualizado = equipoRepositoryMongoDB.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el equipo con id: " + id));
        equipoActualizado.setNombre(equipo.getNombre());
        equipoActualizado.setEntrenador(equipo.getEntrenador());
        equipoActualizado.setFechaFundacion(equipo.getFechaFundacion());
        return equipoRepositoryMongoDB.save(equipoActualizado);
    }

    public void deleteEquipo(String id) {
        equipoRepositoryMongoDB.deleteById(id);
    }
}
