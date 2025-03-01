package org.example.grandao.dtos;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * The type Jugador.
 */
@Entity
@Table(name = "jugador")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "El jugador debe tener nombre")
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del nombre del entrenador debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @NotNull(message = "El jugador debe tener edad")
    @Column(name = "edad", nullable = false)
    @Min(value = 16, message = "La edad minima debe ser 16 años")
    private Integer edad;

    @Column(name = "posicion", length = 50)
    @Pattern(regexp = "^(Portero|Defensa|Mediocentro|Delantero)$" , message = "La posición solo puede ser Portero, Defensa, Mediocentro y Delantero")
    private String posicion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipo_id")
    @JsonIncludeProperties({"id", "nombre"})
    private Equipo equipo;

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
     * Gets edad.
     *
     * @return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Sets edad.
     *
     * @param edad the edad
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * Gets posicion.
     *
     * @return the posicion
     */
    public String getPosicion() {
        return posicion;
    }

    /**
     * Sets posicion.
     *
     * @param posicion the posicion
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    /**
     * Gets equipo.
     *
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }

    /**
     * Sets equipo.
     *
     * @param equipo the equipo
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Instantiates a new Jugador.
     *
     * @param id       the id
     * @param nombre   the nombre
     * @param edad     the edad
     * @param posicion the posicion
     * @param equipo   the equipo
     */
    public Jugador(Integer id, String nombre, Integer edad, String posicion, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    /**
     * Instantiates a new Jugador.
     */
    public Jugador() {
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}