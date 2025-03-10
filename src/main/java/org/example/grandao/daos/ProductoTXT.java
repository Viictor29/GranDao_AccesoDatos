package org.example.grandao.daos;

import java.io.*;
import java.util.*;
import org.example.grandao.dtos.Producto;
import org.springframework.stereotype.Repository;

/**
 * The type Producto txt.
 */
@Repository
public class ProductoTXT {
    private final String archivo = "productos.txt";

    /**
     * Instantiates a new Producto txt.
     */
    public ProductoTXT() {}

    /**
     * Leer productos list.
     *
     * @return the list
     */
    public List<Producto> leerProductos() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    double precio = Double.parseDouble(partes[2].trim());
                    productos.add(new Producto(id, nombre, precio));
                } else {
                    throw new RuntimeException("Error en la lectura del archivo: " + archivo);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return productos;
    }

    /**
     * Buscar por id producto.
     *
     * @param id the id
     * @return the producto
     */
    public Producto buscarPorId(int id) {
        return leerProductos().stream().filter(producto -> producto.getId() == id).findFirst().orElse(null);
    }

    /**
     * Guardar producto.
     *
     * @param producto the producto
     */
    public void guardarProducto(Producto producto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(producto.getId() + "," + producto.getNombre() + "," + producto.getPrecio());
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar el producto: " + e.getMessage());
        }
    }
}
