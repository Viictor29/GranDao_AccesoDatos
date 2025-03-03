package org.example.grandao.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Producto for mongo.
 */
@Document(collection = "productos")
public class ProductoMongo {
    @Id
    private String id;
    private String nombre;
    private double precio;

    /**
     * Instantiates a new Producto mongo.
     */
    public ProductoMongo() {}

    /**
     * Instantiates a new Producto mongo.
     *
     * @param nombre the nombre
     * @param precio the precio
     */
    public ProductoMongo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() { return id; }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) { this.id = id; }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() { return nombre; }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Gets precio.
     *
     * @return the precio
     */
    public double getPrecio() { return precio; }

    /**
     * Sets precio.
     *
     * @param precio the precio
     */
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

