package org.example.grandao.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "partido")
public class PartidoMongoDB {
    @Id
    private String id;  // MongoDB usa String para el id

    @NotNull(message = "El partido debe tener fecha")
    @Field("fecha")
    private LocalDate fecha;

    @DBRef
    @Field("equipo_local")
    private Equipo equipoLocal;

    @DBRef
    @Field("equipo_visitante")
    private Equipo equipoVisitante;

    @NotNull(message = "El partido debe tener goles del equipo local")
    @Field("goles_local")
    @Min(value = 0, message = "Los goles no pueden ser negativos")
    private Integer golesLocal;

    @NotNull(message = "El partido debe tener goles del equipo visitante")
    @Field("goles_visitante")
    @Min(value = 0, message = "Los goles no pueden ser negativos")
    private Integer golesVisitante;

    @DBRef
    @Field("torneo")
    private Torneo torneo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(Integer golesLocal) {
        this.golesLocal = golesLocal;
    }

    public Integer getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(Integer golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public PartidoMongoDB(String id, LocalDate fecha, Equipo equipoLocal, Equipo equipoVisitante, Integer golesLocal, Integer golesVisitante, Torneo torneo) {
        this.id = id;
        this.fecha = fecha;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.torneo = torneo;
    }

    public PartidoMongoDB() {
    }

    @Override
    public String toString() {
        return "PartidoMongoDB{" +
                "id='" + id + '\'' +
                ", fecha=" + fecha +
                ", equipoLocal=" + equipoLocal +
                ", equipoVisitante=" + equipoVisitante +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", torneo=" + torneo +
                '}';
    }
}
