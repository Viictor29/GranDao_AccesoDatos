package org.example.grandao.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productos")
public class ProductoMongo {
    @Id
    private String id;
    private String nombre;
    private double precio;

    public ProductoMongo() {}

    public ProductoMongo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "ProductoMongo{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}

