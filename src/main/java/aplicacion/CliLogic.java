/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Sacrificio;
import aplicacion.model.SacrificioPadre;
import datos.DataLayer;
import datos.ImportarDAO;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.bind.JAXBException;
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
     * Dependiendo del comando que se ha utilizado, se comprueba su longitud de
     * argumentos y se ejecuta la función encargada de la lógica de ese comando.
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
        ImportarDAO datos = new ImportarDAO();
        SacrificioPadre xmlAsObject = (SacrificioPadre) datos.getData();
        String availableOrderColumns = "";

        //Obtenemos el nombre de los fields de sacrificio
        for (Field field : Sacrificio.class.getDeclaredFields()) {
            availableOrderColumns += field.getName() + "\n";
        }

        Pattern p = Pattern.compile("\\b"+columnaOrdenacion+"\\b");
        Matcher m = p.matcher(availableOrderColumns);
        
        if (!m.find()) {
            System.out.println("Columna de ordenación no válida. Las columnas de ordenación válidas son:");
            System.out.println(availableOrderColumns);
            System.exit(0);
        }

        Export export = new Export();
        columnaOrdenacion = columnaOrdenacion.substring(0, 1).toUpperCase() + columnaOrdenacion.substring(1);

        try {
            switch (formatoSalida.toUpperCase()) {
                case "XML":
                    export.exportXML(directorioSalida, columnaOrdenacion, xmlAsObject);
                    break;
                case "CSV":
                    export.exportCSV(directorioSalida, columnaOrdenacion, xmlAsObject);
                    break;
                case "CSVXML", "XMLCSV":
                    export.exportCSVXML(directorioSalida, columnaOrdenacion, xmlAsObject);
                    break;

                default:
                    System.out.println("Argumento de Exportación no válido. (CSV,XML, CSVXML)");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Exportado con éxito. Ruta: " + new File(directorioSalida).getAbsolutePath());
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
        if (clave.length() <= 1) {
            vigPresentation.printVigenereLengthOne();
        }

        //Comprobamos que la clave no sea el mismo caracter repetido --> Ej: aaaa
        if (Pattern.matches("^(.)\\1+$", clave)) {
            vigPresentation.printVigenereSameCharactersInKey();
        }
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
        if (clave.length() <= 1) {
            vigPresentation.printVigenereLengthOne();
        }

        //Comprobamos que la clave no sea el mismo caracter repetido --> Ej: aaaa
        if (Pattern.matches("^(.)\\1+$", clave)) {
            vigPresentation.printVigenereSameCharactersInKey();
        }

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
        String elementosDisponibles = "";
        //Lógica
        ImportarDAO valores = new ImportarDAO();
        SacrificioPadre xmlAsObject = (SacrificioPadre) valores.getData();
        List<Sacrificio> listaElementos = xmlAsObject.getSacrificios();
        
        //Obtenemos el nombre de los fields de sacrificio
        for (Field field : Sacrificio.class.getDeclaredFields()) {
            elementosDisponibles += field.getName() + "\n";
        }
        
        /* Creamos una expresion regular que me busque en el string de elementos disponibles
           los elementos que hay en sacrificio, y si coincide con el elemento que pasa el
           usuario se continua, si no existe se manda un mensaje de error y se muestran los disponibles
        */
        
        Pattern p = Pattern.compile("\\b"+elementoABuscar+"\\b");
        Matcher m = p.matcher(elementosDisponibles);
        
        if (!m.find()) {
            System.out.println("Elemento no encontrado. Los elementos que existen son los siguientes:");
            System.out.println(elementosDisponibles);
            System.exit(0);
        }
        
        /* Una vez tenemos el elemento buscaremos de ese elemento si el nombre que hay existe 
           y lo mostraremos por pantalla
        */
        String primerCaracter = elementoABuscar.substring(0,1).toUpperCase();
        try {
            
            //Creamos una variable de tipo method a la que le podremos hacer un invoke pasandole el objeto que queramos
            Method getElemento = listaElementos.get(0).getClass().getMethod("get" + primerCaracter + elementoABuscar.substring(1));
            
            //Creamos un filtro que 
            List<Sacrificio> elementosFiltrados = listaElementos.stream().filter(e -> {
                try { 
                    //hacemos una comprobacion de si el getter que invocamos es igual a el paramaetro que buscamos 
                    //y lo añade si esta
                    return getElemento.invoke(e).equals(nombreElementoABuscar);
                } catch (Exception ex) {
                    //devolvemos false para que no pete el invoke
                    return false;
                }
            }).toList();
            
            //Imprimimos los objetos filtrados que coincidan con lo buscado por el usuario
            CliPresentationLayer mostrarElementos = new CliPresentationLayer();
            mostrarElementos.printElementos(elementosFiltrados);
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        
    }

}
