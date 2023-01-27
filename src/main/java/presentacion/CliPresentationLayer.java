/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Utils.ErrorMessagesHelpers;
import aplicacion.LogicLayer;
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

    @Override
    public void displayData(Object data) {
        
    }
}
