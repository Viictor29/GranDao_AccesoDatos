package org.example.grandao.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "pedidos")
public class Pedido {
    @Id
    private String id;
    private List<Producto> productos;
    private double total;

    public Pedido() {}

    public Pedido(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public List<Producto> getProductos() { return productos; }
    public void setProductos(List<Producto> productos) { this.productos = productos; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}

