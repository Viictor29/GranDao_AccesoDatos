package org.example.grandao.dtos;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document(collection = "torneo")
public class TorneoMongoDB {

    @Id
    private String id;  // MongoDB usa String para el id

    @Field("nombre")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚ][a-záéíóúÁÉÍÓÚa-zA-Z0-9]*(?: [a-záéíóúÁÉÍÓÚa-zA-Z0-9]+)*$" , message = "La primera letra del torneo debe ser mayuscula y solo valores alfanumericos")
    private String nombre;

    @Field("fecha_inicio")
    private LocalDate fechaInicio;

    @Field("fecha_fin")
    private LocalDate fechaFin;

    @Field("ubicacion")
    @Pattern(regexp = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]*(?: [a-záéíóúñÁÉÍÓÚÑA-Za-z0-9]+)*$" , message = "La primera letra del torneo debe ser mayuscula y solo valores alfanumericos")
    private String ubicacion;

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

    public TorneoMongoDB() {
    }

    @Override
    public String toString() {
        return "TorneoMongoDB{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
