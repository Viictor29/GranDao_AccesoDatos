package org.example.grandao.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "equipo")
public class EquipoMongoDB {

    @Id
    private String id;  // MongoDB usa String por defecto para las claves primarias

    @NotNull(message = "El equipo debe tener un nombre")
    @Field("nombre")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del nombre debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @Field("entrenador")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del nombre del entrenador debe ser mayuscula y solo valores alfanumericos")
    private String entrenador;

    @NotNull(message = "El equipo debe tener fecha de fundacion")
    @Field("fecha_fundacion")
    private LocalDate fechaFundacion;

    //Getters y setters

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

    public EquipoMongoDB(String id, String nombre, String entrenador, LocalDate fechaFundacion) {
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.fechaFundacion = fechaFundacion;
    }

    public EquipoMongoDB() {
    }

    @Override
    public String toString() {
        return "EquipoMongoDB{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", entrenador='" + entrenador + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                '}';
    }
}
