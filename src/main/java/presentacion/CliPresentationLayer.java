/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Utils.ErrorMessagesHelpers;
import aplicacion.LogicLayer;
import org.apache.commons.cli.Options;

/**
 * Clase de presentación para los Cli. 
 */
public class CliPresentationLayer extends PresentationLayer{
    
    //Opciones del comando
    private Options options;
    //Texto que define al comando
    private String command;

    /**
     * Constructor de la presentación de los comandos
     * @param options opciones del comando
     * @param command comando 
     */
    public CliPresentationLayer(Options options, String command) {
        this.options = options;
        this.command = command;
    }
    
    public CliPresentationLayer() {
        
    }
    
    /**
     * Printeo el comando de ayuda.
     */
    public void printCommandHelp(){
        ErrorMessagesHelpers.printCommandHelp(options, command);
    }
    /**
     * Printea el comando de ayuda y una excepción.
     * @param e 
     */
    public void printCommandHelp(Exception e){
        ErrorMessagesHelpers.printCommandHelp(options, command, e);
    }
    
    /**
     * Printea el texto de la ayuda principal
     */
    public void printMainHelper(){
        ErrorMessagesHelpers.printMainHelper();
    }

    @Override
    public void displayData(Object data) {
        
    }
}
