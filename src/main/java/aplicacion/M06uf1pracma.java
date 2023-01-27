/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package aplicacion;

import Utils.CliManager;
import Utils.ErrorMessagesHelpers;
import datos.CliDataLayer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import presentacion.CliPresentationLayer;
import presentacion.PresentationLayer;

/**
 * Clase Principal de la aplicación
 * @author Cole
 */
public class M06uf1pracma {

    /**
     * Funció que se ejecuta al ejecutar la aplicación
     * @param args argumentos del usuario al ejecutar la aplicación
     */
    public static void main(String[] args) {
        
        CliManager manager = new CliManager();
        CliPresentationLayer presentation = new CliPresentationLayer();
        
        if(args.length < 1){
            presentation.printMainHelper();
            System.exit(0);
        }
        
        Options options = null;
        //Comprobar el primer argumento --> report, export, import, decrypt o encrypt
        switch (args[0]) {
            case "report" -> options = manager.getReportOptions();
            case "export" -> options = manager.getExportOptions();
            case "encrypt" -> options = manager.getEncryptOptions();
            case "decrypt" -> options = manager.getDecryptOptions();
            case "search" -> options = manager.getSearchOptions();
            default -> presentation.printMainHelper();
        }
        
        presentation = new CliPresentationLayer(options, args[0]);
        CliDataLayer data = new CliDataLayer(args, options);
        CliLogic logic = new CliLogic(presentation, data);
        logic.processData();
        
    }
}
