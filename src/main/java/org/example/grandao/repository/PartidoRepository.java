package org.example.grandao.repository;

import org.example.grandao.dtos.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}
