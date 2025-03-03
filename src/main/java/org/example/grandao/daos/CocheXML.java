package org.example.grandao.daos;


import org.example.grandao.dtos.Coche;
import org.example.grandao.dtos.CochesList;
import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
     * Leer coches por matricula list.
     *
     * @param matricula the marca
     * @return the list
     * @throws JAXBException the jaxb exception
     */
    public List<Coche> leerCochesPorMatricula(String matricula) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CochesList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        CochesList wrapper = (CochesList) unmarshaller.unmarshal(new File(archivo));

        List<Coche> cochesFiltradosMatricula = new ArrayList<>();
        for (Coche coche : wrapper.getCoches()) {
            if (coche.getMarca().equals(matricula)) {
                cochesFiltradosMatricula.add(coche);
            }
        }
        return cochesFiltradosMatricula;
    }

}
