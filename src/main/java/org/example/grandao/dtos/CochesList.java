package org.example.grandao.dtos;

import jakarta.xml.bind.annotation.XmlElement;

import java.util.List;

/**
 * The type Coches list.
 */
public class CochesList {

    private List<Coche> coches;

    /**
     * Instantiates a new Coches list.
     */
// Constructor vacío
    public CochesList() {

    }

    /**
     * Instantiates a new Coches list.
     *
     * @param coches the coches
     */
// Constructor con lista de coches
    public CochesList(List<Coche> coches) {
        this.coches = coches;
    }

    /**
     * Gets coches.
     *
     * @return the coches
     */
    @XmlElement(name = "coche")
    public List<Coche> getCoches() {
        return coches;
    }

    /**
     * Sets coches.
     *
     * @param coches the coches
     */
    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }
}
