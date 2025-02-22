package org.example.grandao.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚ][a-záéíóúÁÉÍÓÚa-zA-Z0-9]*(?: [a-záéíóúÁÉÍÓÚa-zA-Z0-9]+)*$" , message = "La primera letra del torneo debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;


    @Column(name = "ubicacion", length = 100)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚ][a-záéíóúÁÉÍÓÚa-zA-Z0-9]*(?: [a-záéíóúÁÉÍÓÚa-zA-Z0-9]+)*$" , message = "La primera letra del torneo debe ser mayuscula y solo valores alfanumericos")
    private String ubicacion;


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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    public Torneo(Integer id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
    }

    public Torneo() {
    }

    @Override
    public String toString() {
        return "Torneo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}