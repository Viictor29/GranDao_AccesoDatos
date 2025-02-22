package org.example.grandao.dtos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "entrenador", length = 100)
    private String entrenador;

    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;

    @OneToMany(mappedBy = "equipo")
    private Set<Jugador> jugadors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoLocal")
    private Set<Partido> partidosLocal = new LinkedHashSet<>();

    @OneToMany(mappedBy = "equipoVisitante")
    private Set<Partido> partidosVisitante = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public Set<Jugador> getJugadors() {
        return jugadors;
    }

    public void setJugadors(Set<Jugador> jugadors) {
        this.jugadors = jugadors;
    }

    public Set<Partido> getPartidosLocal() {
        return partidosLocal;
    }

    public void setPartidosLocal(Set<Partido> partidosLocal) {
        this.partidosLocal = partidosLocal;
    }

    public Set<Partido> getPartidosVisitante() {
        return partidosVisitante;
    }

    public void setPartidosVisitante(Set<Partido> partidosVisitante) {
        this.partidosVisitante = partidosVisitante;
    }

    public Equipo(Integer id, String nombre, String entrenador, LocalDate fechaFundacion, Set<Jugador> jugadors, Set<Partido> partidosLocal, Set<Partido> partidosVisitante) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.fechaFundacion = fechaFundacion;
        this.jugadors = jugadors;
        this.partidosLocal = partidosLocal;
        this.partidosVisitante = partidosVisitante;
    }

    public Equipo() {
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", entrenador='" + entrenador + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", jugadors=" + jugadors +
                ", partidosLocal=" + partidosLocal +
                ", partidosVisitante=" + partidosVisitante +
                '}';
    }
}