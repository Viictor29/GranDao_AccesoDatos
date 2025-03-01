package org.example.grandao.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The type Equipo.
 */
@Entity
@Table(name = "equipo")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "El equipo debe tener un nombre")
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del nombre debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @Column(name = "entrenador", length = 100)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del nombre del entrenador debe ser mayuscula y solo valores alfanumericos")
    private String entrenador;

    @NotNull(message = "El equipo debe tener fecha de fundacion")
    @Column(name = "fecha_fundacion")
    private LocalDate fechaFundacion;


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
     * Gets entrenador.
     *
     * @return the entrenador
     */
    public String getEntrenador() {
        return entrenador;
    }

    /**
     * Sets entrenador.
     *
     * @param entrenador the entrenador
     */
    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Gets fecha fundacion.
     *
     * @return the fecha fundacion
     */
    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    /**
     * Sets fecha fundacion.
     *
     * @param fechaFundacion the fecha fundacion
     */
    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }


    /**
     * Instantiates a new Equipo.
     *
     * @param id             the id
     * @param nombre         the nombre
     * @param entrenador     the entrenador
     * @param fechaFundacion the fecha fundacion
     */
    public Equipo(Integer id, String nombre, String entrenador, LocalDate fechaFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.fechaFundacion = fechaFundacion;
    }

    /**
     * Instantiates a new Equipo.
     */
    public Equipo() {
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", entrenador='" + entrenador + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                '}';
    }
}