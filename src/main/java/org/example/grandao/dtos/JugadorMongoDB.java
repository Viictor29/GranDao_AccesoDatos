package org.example.grandao.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "jugador")
public class JugadorMongoDB {

    @Id
    private String id;  // MongoDB usa String para el id

    @NotNull(message = "El jugador debe tener nombre")
    @Field("nombre")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del nombre del entrenador debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @NotNull(message = "El jugador debe tener edad")
    @Field("edad")
    @Min(value = 16, message = "La edad minima debe ser 16 años")
    private Integer edad;

    @Field("posicion")
    @Pattern(regexp = "^(Portero|Defensa|Mediocentro|Delantero)$" , message = "La posición solo puede ser Portero, Defensa, Mediocentro y Delantero")
    private String posicion;

    @DBRef  // MongoDB usa referencias con @DBRef para establecer relaciones
    @Field("equipo")
    private Equipo equipo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public JugadorMongoDB(String id, String nombre, Integer edad, String posicion, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.equipo = equipo;
    }

    public JugadorMongoDB() {
    }

    @Override
    public String toString() {
        return "JugadorMongoDB{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", posicion='" + posicion + '\'' +
                ", equipo=" + equipo +
                '}';
    }
}
