package org.example.grandao.dtos;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

public class CochesList {

    private List<Coche> coches;

    // Constructor vacío
    public CochesList() {

    }

    // Constructor con lista de coches
    public CochesList(List<Coche> coches) {
        this.coches = coches;
    }

    @XmlElement(name = "coche")
    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}
