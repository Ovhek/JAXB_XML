/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Utils.ErrorMessagesHelpers;
import aplicacion.LogicLayer;
import aplicacion.model.Sacrificio;
import java.util.List;
import org.apache.commons.cli.Options;

/**
 *
 * @author Cole
 */
public class CliPresentationLayer extends PresentationLayer{
    
    private Options options;
    private String command;

    public CliPresentationLayer(Options options, String command) {
        this.options = options;
        this.command = command;
    }
    public CliPresentationLayer() {
        
    }
    public void printCommandHelp(Exception e){
        ErrorMessagesHelpers.printCommandHelp(options, command, e);
    }
    public void printMainHelper(){
        ErrorMessagesHelpers.printMainHelper();
    }
    
    public void printElementos(List<Sacrificio> elementosFiltrados){
    
        for (int i = 0; i < elementosFiltrados.size()-1 ; i++) {
                System.out.println(elementosFiltrados.get(i).toString());
            }
    }

    @Override
    public void displayData(Object data) {
        
    }
}
