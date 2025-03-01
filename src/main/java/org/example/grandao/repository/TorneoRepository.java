package org.example.grandao.repository;

import org.example.grandao.dtos.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Torneo repository.
 */
public interface TorneoRepository extends JpaRepository<Torneo, Integer> {
}
