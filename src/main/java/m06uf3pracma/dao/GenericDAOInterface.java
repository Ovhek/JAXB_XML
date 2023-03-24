/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m06uf3pracma.dao;

import java.util.List;
import m06uf3pracma.model.IdProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author Alex
 */
public interface GenericDAOInterface<Entidad extends IdProvider> {
    public List<Entidad> getAll();
    public Entidad getById(ObjectId id);
    public void update(Entidad entidad);
    public void save(Entidad entidad);
    public void delete(Entidad entidad);
    
}
