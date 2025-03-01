package org.example.grandao.daos;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.grandao.dtos.Coche;
import org.example.grandao.dtos.CochesList;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Coche xml.
 */
@Repository
public class CocheXML {

    private static final String archivo = "coches.xml";


    /**
     * Leer coches list.
     *
     * @return the list
     * @throws JAXBException the jaxb exception
     */
    public List<Coche> leerCoches() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CochesList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CochesList wrapper = (CochesList) unmarshaller.unmarshal(new File(archivo));
        return wrapper.getCoches();
    }

    /**
     * Guardar coches.
     *
     * @param listaCoches the lista coches
     * @throws JAXBException the jaxb exception
     */
    public void guardarCoches(List<Coche> listaCoches) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CochesList.class);  // Usamos la clase CochesList como "wrapper"
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  // Configura el formato del XML
        marshaller.marshal(new CochesList(listaCoches), new File(archivo));  // Convierte la lista de coches a XML y lo guarda en el archivo
    }

    /**
     * Leer coches por marca list.
     *
     * @param marca the marca
     * @return the list
     * @throws JAXBException the jaxb exception
     */
    public List<Coche> leerCochesPorMarca(String marca) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CochesList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CochesList wrapper = (CochesList) unmarshaller.unmarshal(new File(archivo));

        List<Coche> cochesFiltradosMarca = new ArrayList<>();
        for (Coche coche : wrapper.getCoches()) {
            if (coche.getMarca().equals(marca)) {
                cochesFiltradosMarca.add(coche);
            }
        }
        return cochesFiltradosMarca;
    }

    /**
     * Leer coches por modelo list.
     *
     * @param modelo the modelo
     * @return the list
     * @throws JAXBException the jaxb exception
     */
    public List<Coche> leerCochesPorModelo(String modelo) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CochesList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CochesList wrapper = (CochesList) unmarshaller.unmarshal(new File(archivo));

        List<Coche> cochesFiltradosModelo = new ArrayList<>();
        for (Coche coche : wrapper.getCoches()) {
            if (coche.getMarca().equals(modelo)) {
                cochesFiltradosModelo.add(coche);
            }
        }
        return cochesFiltradosModelo;
    }

}
