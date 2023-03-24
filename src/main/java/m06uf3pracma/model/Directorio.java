/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m06uf3pracma.model;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Alex
 */
public class Directorio implements IdProvider{
    private ObjectId id;
    private String ruta;
    private List<Documento> documentos;
    private List<Directorio> directorios;
    
    public Directorio() {
    }

    public String getRuta() {
        return ruta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<Directorio> getDirectorios() {
        return directorios;
    }

    public void setDirectorios(List<Directorio> directorios) {
        this.directorios = directorios;
    }
    
}
