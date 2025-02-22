package org.example.grandao.service;

import org.example.grandao.dtos.Equipo;
import org.example.grandao.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    EquipoRepository equipoRepository;

    @Autowired
    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> getEquipos() {
        return equipoRepository.findAll();
    }

    public Equipo getEquipoById(int id) {
        return equipoRepository.findById(id).get();
    }

    public Equipo createEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo updateEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteEquipo(int id) {
        equipoRepository.deleteById(id);
    }
}
