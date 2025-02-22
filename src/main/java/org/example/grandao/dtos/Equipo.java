package org.example.grandao.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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

    @NotNull(message = "El equipo debe tener un nombre")
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$" , message = "La primera letra del nombre debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @Column(name = "entrenador", length = 100)
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9]*$" , message = "La primera letra del nombre del entrenador debe ser mayuscula y solo valores alfanumericos")
    private String entrenador;

    @NotNull(message = "El equipo debe tener fecha de fundacion")
    @Column(name = "fecha_fundacion")
    @Pattern(regexp = "^[0-9]{4}$" , message = "La fecha de fundación tiene que ser obligatoriamente 4 dígitos")
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