/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * Clase que muestra los mensajes de ayuda de los comandos
 */
public abstract class ErrorMessagesHelpers {

    /**
     * Función encargada de mostrar el mensaje de ayuda de un comando.
     * @param options Opciones del comando
     * @param command Comando en cuestión
     */
    public static void printCommandHelp(Options options,String command, Exception e) {
        HelpFormatter formatter = new HelpFormatter();
        System.out.println("El comando se ha utilizado de forma incorrecta.");
        System.out.println(e.getMessage());
        formatter.printHelp(command, options);
        System.exit(0);
    }
    /**
     * Función encargada de mostrar la ayuda de los comandos principales.
     */
    public static void printMainHelper() {
        System.out.println("Comandos soportados:");
        System.out.println("\treport\t --- Creación de reportes.");
        System.out.println("\texport\t --- Exportar el archivo.");
        System.out.println("\tencrypt\t --- Encrypta un archivo.");
        System.out.println("\tdecrypt\t --- Desencripta un archivo.");
        System.out.println("\tsearch\t --- Busca en el archivo");
        System.exit(0);
    }
}
