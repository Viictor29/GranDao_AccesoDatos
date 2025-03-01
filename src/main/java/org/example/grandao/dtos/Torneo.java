package org.example.grandao.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Torneo.
 */
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
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del torneo debe ser mayuscula y solo valores alfanumericos")
    private String ubicacion;


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
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets fecha inicio.
     *
     * @return the fecha inicio
     */
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets fecha inicio.
     *
     * @param fechaInicio the fecha inicio
     */
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Gets fecha fin.
     *
     * @return the fecha fin
     */
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    /**
     * Sets fecha fin.
     *
     * @param fechaFin the fecha fin
     */
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * Gets ubicacion.
     *
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Sets ubicacion.
     *
     * @param ubicacion the ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }


    /**
     * Instantiates a new Torneo.
     *
     * @param id          the id
     * @param nombre      the nombre
     * @param fechaInicio the fecha inicio
     * @param fechaFin    the fecha fin
     * @param ubicacion   the ubicacion
     */
    public Torneo(Integer id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
    }

    /**
     * Instantiates a new Torneo.
     */
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