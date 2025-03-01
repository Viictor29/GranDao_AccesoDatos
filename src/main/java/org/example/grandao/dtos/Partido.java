package org.example.grandao.dtos;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * The type Partido.
 */
@Entity
@Table(name = "partido")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "El partido debe tener fecha")
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_local_id")
    @JsonIncludeProperties({"id", "nombre"})
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_visitante_id")
    @JsonIncludeProperties({"id", "nombre"})
    private Equipo equipoVisitante;

    @NotNull(message = "El partido debe tener goles del equipo local")
    @Column(name = "goles_local")
    @Min(value = 0, message = "Los goles no pueden ser negativos")
    private Integer golesLocal;

    @NotNull(message = "El partido debe tener goles del equipo visitante")
    @Column(name = "goles_visitante")
    @Min(value = 0, message = "Los goles no pueden ser negativos")
    private Integer golesVisitante;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "torneo_id")
    @JsonIncludeProperties({"id", "nombre"})
    private Torneo torneo;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets fecha.
     *
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Sets fecha.
     *
     * @param fecha the fecha
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Gets equipo local.
     *
     * @return the equipo local
     */
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * Sets equipo local.
     *
     * @param equipoLocal the equipo local
     */
    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * Gets equipo visitante.
     *
     * @return the equipo visitante
     */
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     * Sets equipo visitante.
     *
     * @param equipoVisitante the equipo visitante
     */
    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    /**
     * Gets goles local.
     *
     * @return the goles local
     */
    public Integer getGolesLocal() {
        return golesLocal;
    }

    /**
     * Sets goles local.
     *
     * @param golesLocal the goles local
     */
    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    /**
     * Gets goles visitante.
     *
     * @return the goles visitante
     */
    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    /**
     * Sets goles visitante.
     *
     * @param golesVisitante the goles visitante
     */
    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    /**
     * Gets torneo.
     *
     * @return the torneo
     */
    public Torneo getTorneo() {
        return torneo;
    }

    /**
     * Sets torneo.
     *
     * @param torneo the torneo
     */
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    /**
     * Instantiates a new Partido.
     *
     * @param id              the id
     * @param fecha           the fecha
     * @param equipoLocal     the equipo local
     * @param equipoVisitante the equipo visitante
     * @param golesLocal      the goles local
     * @param golesVisitante  the goles visitante
     * @param torneo          the torneo
     */
    public Partido(Integer id, LocalDate fecha, Equipo equipoLocal, Equipo equipoVisitante, Integer golesLocal, Integer golesVisitante, Torneo torneo) {
        this.id = id;
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.torneo = torneo;
    }

    /**
     * Instantiates a new Partido.
     */
    public Partido() {
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", torneo=" + torneo +
                '}';
    }
}