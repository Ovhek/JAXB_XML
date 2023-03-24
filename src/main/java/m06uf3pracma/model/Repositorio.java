/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m06uf3pracma.model;

import org.bson.types.ObjectId;

/**
 *
 * @author Alex
 */
public class Repositorio implements IdProvider{
    private ObjectId _id;
    private String nombre;
    private Directorio raiz;

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public Repositorio() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Directorio getRaiz() {
        return raiz;
    }

    public void setRaiz(Directorio raiz) {
        this.raiz = raiz;
    }
}
