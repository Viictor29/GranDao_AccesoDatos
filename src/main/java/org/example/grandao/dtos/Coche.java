package org.example.grandao.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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


    // Constructor vacío para JAXB
    public Coche() {}

    // Constructor con parámetros
    public Coche(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    // Getters y setters
    @XmlElement
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @XmlElement
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @XmlElement
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
