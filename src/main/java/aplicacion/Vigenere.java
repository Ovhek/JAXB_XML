/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import java.io.*;

/**
 * Clase encargada de proporcionar las funciones de encriptar y desencriptar
 * utilizando el agoritmo de Vigenere.
 */
public abstract class Vigenere {

    //Tamaño del afabeto de Vigenere a usar
    private static final int ALPHABET_SIZE = 256;
    //Tamaño del buffer
    private static final int BUFFER_SIZE = 4096;
    /**
     * Función encargada de encriptar el fichero y guardar el fichero encriptado.
     * @param key La clave a usar para encriptar
     * @param inputFilePath Ruta del archivo de entrada
     * @param outputFilePath Ruta del archvio de salida
     * @throws IOException Error al manejar los archivos
     */
    public static void encryptFile(String key, String inputFilePath, String outputFilePath) throws IOException {
        //Abrimos los archivos
        FileInputStream fis = new FileInputStream(inputFilePath);
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        
        //Creamos el buffer de bytes
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        int keyIndex = 0;
        byte[] keyBytes = key.getBytes();
        
        //Bucle que continua hasta haber acabado de leer el archivo
        while((bytesRead = fis.read(buffer)) != -1){
                //Bucle que va desde 0 hasta el final del buffer de bytes leido
                for (int i = 0; i < bytesRead; i++) {
                    //Linea encargada de cifrar el archivo. 
                    //Tomamos el byte actual en el buffer y le sumamos el byte correspondiente a la clave. Luego aplicamos el modulo del alfabeto
                    buffer[i] = (byte)((buffer[i] + keyBytes[keyIndex])% ALPHABET_SIZE);
                    //Nos aseguramos que se utiliza la clave de forma cíclica.
                    //Incrementamos el indice de la clave en 1 en cada iteración del bucle.
                    //Si el indice excede la longitud de la clave. Se toma el módulo de la longitud de la clave para volver al principio de la clave y seguir cifrando.
                    keyIndex = (keyIndex + 1) % key.length();
                }
                fos.write(buffer, 0, bytesRead);
        }
        fis.close();
        fos.close();
    }

    /**
     * Función encargada de desencriptar un archivo utilizando Vigenere
     * @param key La clave para desencriptar
     * @param inputFilePath Ruta del archivo de entrada
     * @param outputFilePath Ruta del archivo de salida
     * @throws IOException 
     */
    public static void decryptFile(String key, String inputFilePath, String outputFilePath) throws IOException {
        //Abrimos los archivos
        FileInputStream fis = new FileInputStream(inputFilePath);
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        
        //Creamos el buffer de bytes
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead;
        int keyIndex = 0;
        byte[] keyBytes = key.getBytes();
        
        while((bytesRead = fis.read(buffer)) != -1){
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] = (byte)((buffer[i] - keyBytes[keyIndex]) % ALPHABET_SIZE);
                    keyIndex = (keyIndex + 1) % key.length();
                }
                fos.write(buffer, 0, bytesRead);
        }
        fis.close();
        fos.close();
    }
}
