package org.example.grandao.dtos;

/**
 * The type Producto for txt.
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;

    /**
     * Instantiates a new Producto.
     *
     * @param id     the id
     * @param nombre the nombre
     * @param precio the precio
     */
    public Producto(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
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
     * Gets precio.
     *
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return id + ", " + nombre + ", $" + precio;
    }
}

