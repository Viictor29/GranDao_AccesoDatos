package org.example.grandao.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * The type Coche.
 */
@Entity
@XmlRootElement
@Table(name = "coches", uniqueConstraints = @UniqueConstraint(columnNames = "matricula"))
public class Coche {

    @Id
    @NotBlank(message = "La matrícula no puede estar vacía")
    @Column(name = "matricula", unique = true, nullable = false)
    private String matricula;

    @NotBlank(message = "La marca no puede estar vacía")
    @Column(name = "marca", nullable = false)
    private String marca;

    @NotBlank(message = "El modelo no puede estar vacío")
    @Column(name = "modelo", nullable = false)
    private String modelo;


    /**
     * Instantiates a new Coche.
     */
// Constructor vacío para JAXB
    public Coche() {}

    /**
     * Instantiates a new Coche.
     *
     * @param matricula the matricula
     * @param marca     the marca
     * @param modelo    the modelo
     */
// Constructor con parámetros
    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Gets matricula.
     *
     * @return the matricula
     */
// Getters y setters
    @XmlElement
    public String getMatricula() {
        return matricula;
    }

    /**
     * Sets matricula.
     *
     * @param matricula the matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Gets marca.
     *
     * @return the marca
     */
    @XmlElement
    public String getMarca() {
        return marca;
    }

    /**
     * Sets marca.
     *
     * @param marca the marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Gets modelo.
     *
     * @return the modelo
     */
    @XmlElement
    public String getModelo() {
        return modelo;
    }

    /**
     * Sets modelo.
     *
     * @param modelo the modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
