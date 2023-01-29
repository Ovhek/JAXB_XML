/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import datos.DataLayer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.apache.commons.cli.CommandLine;
import presentacion.CliPresentationLayer;
import presentacion.PresentationLayer;
import presentacion.VigenerePresentation;

/**
 * Clase encargada de la lógica de los comandos
 *
 * @author Cole
 */
public class CliLogic extends LogicLayer {

    public CliLogic(PresentationLayer presentation, DataLayer data) {
        super(presentation, data);
    }

    /**
     * Función encargada de procesar los datos obtenidos del dataLayer. 
     * Dependiendo del comando que se ha utilizado, se comprueba su longitud 
     * de argumentos y se ejecuta la función encargada de la lógica de ese comando.
     */
    @Override
    public void processData() {
        CliPresentationLayer presentation = (CliPresentationLayer) this.presentation;
        try {
            CommandLine cmd = (CommandLine) data.getData();
            if (cmd.getArgs().length == 0) {
                presentation.printCommandHelp(new IllegalArgumentException("No se han especificado las opciones del comando de forma correcta."));
            }
            //Comprobar el primer argumento --> report, export, import, decrypt o encrypt
            switch (cmd.getArgs()[0]) {
                case "report" -> {
                    if (cmd.getOptions().length < 3) {
                        presentation.printCommandHelp(new IllegalArgumentException("No se han especificado las opciones del comando de forma correcta."));
                    }
                    manageReportCommand(cmd);
                }
                case "export" -> {
                    if (cmd.getOptions().length < 3) {
                        presentation.printCommandHelp(new IllegalArgumentException("No se han especificado las opciones del comando de forma correcta."));
                    }
                    manageExportCommand(cmd);
                }
                case "encrypt" -> {
                    if (cmd.getOptions().length < 3) {
                        presentation.printCommandHelp(new IllegalArgumentException("No se han especificado las opciones del comando de forma correcta."));
                    }
                    manageEncryptCommand(cmd);
                }
                case "decrypt" -> {
                    if (cmd.getOptions().length < 3) {
                        presentation.printCommandHelp(new IllegalArgumentException("No se han especificado las opciones del comando de forma correcta."));
                    }
                    manageDecryptCommand(cmd);
                }
                case "search" -> {
                    if (cmd.getOptions().length < 2) {
                        presentation.printCommandHelp(new IllegalArgumentException("No se han especificado las opciones del comando de forma correcta."));
                    }
                    manageSearchCommand(cmd);
                }
                default ->
                    presentation.printMainHelper();
            }

        } catch (Exception ex) {
            presentation.printCommandHelp(ex);
        }
    }

    /**
     * Función encargada de manejar el comando de reportes. Obtiene los datos de
     * los parametros y ejecuta la lógica
     *
     * @param cmd Linea de comandos
     */
    private static void manageReportCommand(CommandLine cmd) {
        //Obtención de datos
        String tipoInforme = cmd.getOptionValue("tipo_informe");
        String opcionExportar = cmd.getOptionValue("opcion_exportar");
        String directorio = cmd.getOptionValue("directorio");

        //Lógica
    }

    /**
     * Función encargada de manejar el comando de exportaciones. Obtiene los
     * datos de los parametros y ejecuta la lógica
     *
     * @param cmd Linea de comandos
     */
    private static void manageExportCommand(CommandLine cmd) {
        //Obtención de datos
        String formatoSalida = cmd.getOptionValue("f");
        String directorioSalida = cmd.getOptionValue("o");
        String columnaOrdenacion = cmd.getOptionValue("c");

        //Lógica
    }

    /**
     * Función encargada de manejar el comando de Encriptaciones. Obtiene los
     * datos de los parametros y ejecuta la lógica
     *
     * @param cmd Linea de comandos
     */
    private static void manageEncryptCommand(CommandLine cmd) {
        //Obtención de datos
        String clave = cmd.getOptionValue("k");
        String directorioSalida = cmd.getOptionValue("o");
        String directorioEntrada = cmd.getOptionValue("i");
        
        VigenerePresentation vigPresentation = new VigenerePresentation();
        
        //Longitud mayor a 1
        if(clave.length() <= 1) vigPresentation.printVigenereLengthOne();
        
        //Comprobamos que la clave no sea el mismo caracter repetido --> Ej: aaaa
        if(Pattern.matches("^(.)\\1+$", clave)) vigPresentation.printVigenereSameCharactersInKey();
        //Lógica
        try {
            Vigenere.encryptFile(clave, directorioEntrada, directorioSalida);
            vigPresentation.displayData(directorioSalida);
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error: " + ex.getMessage());
        }
        
    }

    /**
     * Función encargada de manejar el comando de desencriptaciones. Obtiene los
     * datos de los parametros y ejecuta la lógica
     *
     * @param cmd Linea de comandos
     */
    private static void manageDecryptCommand(CommandLine cmd) {
        //Obtención de datos
        String clave = cmd.getOptionValue("k");
        String directorioSalida = cmd.getOptionValue("o");
        String directorioEntrada = cmd.getOptionValue("i");

        VigenerePresentation vigPresentation = new VigenerePresentation();
        
        //Longitud mayor a 1
        if(clave.length() <= 1) vigPresentation.printVigenereLengthOne();
        
        //Comprobamos que la clave no sea el mismo caracter repetido --> Ej: aaaa
        if(Pattern.matches("^(.)\\1+$", clave)) vigPresentation.printVigenereSameCharactersInKey();
        
        //Lógica
        try {
            Vigenere.decryptFile(clave, directorioEntrada, directorioSalida);
            vigPresentation.displayData(directorioSalida);
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error: " + ex.getMessage());
        }
    }

    /**
     * Función encargada de manejar el comando de buscar. Obtiene los datos de
     * los parametros y ejecuta la lógica
     *
     * @param cmd Linea de comandos
     */
    private static void manageSearchCommand(CommandLine cmd) {
        //Obtención de datos
        String elementoABuscar = cmd.getOptionValue("elemento");
        String nombreElementoABuscar = cmd.getOptionValue("nombre");

        //Lógica
    }

}
