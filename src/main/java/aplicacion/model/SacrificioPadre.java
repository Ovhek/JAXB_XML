/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bhugo
 */

//indiquem que  s'ha d'incloure aquesta classe com a element
@XmlRootElement (name = "Rows")
public class SacrificioPadre {
    
    // Indicamos la relacion con Sacrificio
    @XmlElement(name = "Row")
    private List<Sacrificio> sacrificios = new ArrayList<Sacrificio>();

    //Definicmos el getter y el setter
    public List<Sacrificio> getSacrificios() {
        return sacrificios;
    }

    public void setSacrificios(ArrayList<Sacrificio> sacrificios) {
        this.sacrificios = sacrificios;
    }

    //ToString method
    @Override
    public String toString() {
        return "SacrificioPadre{" + "sacrificios=" + sacrificios + '}';
    }
    
}
