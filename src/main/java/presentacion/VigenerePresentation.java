/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.io.File;

/**
 * Capa de presentación de Vigenere. Encargada de imprimir toda la información relacionada con Vigenere
 * @author Cole
 */
public class VigenerePresentation extends PresentationLayer{

    /**
     * Función que se ejecuta cuando el comandos e ha ejecutado de forma correcta. Devuelve un mensaje y la ruta donde se ha encriptado o desencriptado el archivo.
     * @param data ruta del archivo
     */
    @Override
    public void displayData(Object data) {
        System.out.println("Comando ejecutado correctamente. Se ha creado el nuevo archivo en la ruta: "+ new File(data.toString()).getAbsolutePath());
        System.exit(0);
    }
    
    /**
     * Mensaje de error que se muestra cuando la clave de Vigenere solo tiene 1 de longitud.
     */
    public void printVigenereLengthOne(){
        System.out.println("La longitud de la clave ha de ser mayor a 1.");
        System.exit(0);
    }
    /**
     * Mensaje de error que se muestra cuando la clave tiene el mismo caracter.
     */
    public void printVigenereSameCharactersInKey(){
        System.out.println("La clave no puede estar formada por un único caracter.");
        System.exit(0);  
    }
}
