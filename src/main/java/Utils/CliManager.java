/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Clase Singleton encargada de manejar las opciones de la línea de comandos.
 * @author Cole
 */
public class CliManager {
    //Opciones de los comandos
    private Options exportOptions;
    private Options reportOptions;
    private Options encryptOptions;
    private Options decryptOptions;
    private Options searchOptions;

    public Options getExportOptions() {
        return exportOptions;
    }

    public Options getReportOptions() {
        return reportOptions;
    }

    public Options getEncryptOptions() {
        return encryptOptions;
    }

    public Options getDecryptOptions() {
        return decryptOptions;
    }

    public Options getSearchOptions() {
        return searchOptions;
    }

    public CommandLine getCmd() {
        return cmd;
    }
    
    //Línea de comandos con las opciones
    private CommandLine cmd;
    
    /**
     * Constructor que instancia las opciones de los comandos.
     */
    public CliManager() {
        cmd = null;
        addAllOptions();
    }
    
    /**
     * Función encargada de asginar las opciones de los comandos.
     */
    private void addAllOptions() {
        exportOptions = new Options();        
        //Exportar
        exportOptions.addOption("f", "format", true, "Formato de salida (CSV, XML o CSVXML)");
        exportOptions.addOption("o", "output", true, "Directorio del archivo de salida");
        exportOptions.addOption("c", "columna", true, "Elemento sobre el cual ordenar la exportación");
        
        // Reporte
        reportOptions = new Options();  
        reportOptions.addOption("opcion_exportar", true, "Opción de exportación");
        reportOptions.addOption("directorio", true, "Directorio de Exportación");
        reportOptions.addOption("tipo_informe", true, "Tipo de informe");
        
        //Encriptar
        encryptOptions = new Options();
        encryptOptions.addOption("i", "input", true, "Directorio del archivo de entrada");
        encryptOptions.addOption("o", "output", true, "Directorio del archivo de salida");
        encryptOptions.addOption("k", "key", true, "Clave de Encriptación/Desencriptación");
        
        //Desencriptar
        decryptOptions = new Options();
        decryptOptions.addOption("i", "input", true, "Directorio del archivo de entrada");
        decryptOptions.addOption("o", "output", true, "Directorio del archivo de salida");
        decryptOptions.addOption("k", "key", true, "Clave de Encriptación/Desencriptación");
        
        // Buscar
        searchOptions = new Options();
        searchOptions.addOption("e","elemento", true, "Elemento a buscar");
        searchOptions.addOption("n","nombre", true, "Nombre del elemento a buscar");
    }
    
    /**
     * Función encargada de parsear la linea de comandos con las opciones dadas
     * @param options Las opciones que están disponibles
     * @param args Argumentos de la linea de comandos
     * @return Linea de comandos parseada
     */
    public CommandLine parseOptions(Options options,String[] args) throws ParseException {
        CliManager manager = new CliManager();
        cmd = manager.parseOptions(options, args);
        return cmd;
    }
}
