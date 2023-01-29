/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import aplicacion.model.SacrificioPadre;
import java.io.File;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Cole
 */
public class ImportarDAO extends DataLayer {
    
    static JAXBContext context;
    
    public Object getData(){
        
        SacrificioPadre datos = null;
        try {
            // Crear una nueva instancia de JAXBContext para el paquete que contiene las clases mapeadas
            context = JAXBContext.newInstance(SacrificioPadre.class);
            
            //Preparamos el fichero de destino
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream("sacrificios_equino_2021.xml");
            
            // Crear un nuevo unmarshaller (XML ----> Objecte)
            Unmarshaller unmarshaller = context.createUnmarshaller();
            
            //deserialitzem XML 
            datos = (SacrificioPadre)unmarshaller.unmarshal(stream);
            
        }catch(JAXBException e) {
            
            e.printStackTrace();
            
        }
        return datos;  
    }
}
