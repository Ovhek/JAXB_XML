/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.DataLayer;
import presentacion.PresentationLayer;

/**
 *
 * @author Cole
 */
public class LogicLayer {
    protected PresentationLayer presentation;
    protected DataLayer data;

    public LogicLayer(PresentationLayer presentation, DataLayer data) {
        this.presentation = presentation;
        this.data = data;
    }
    
    
}
