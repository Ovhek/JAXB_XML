/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author Cole
 */
public class VigenerePresentation extends PresentationLayer{

    @Override
    public void displayData(Object data) {
        System.out.println("Comando ejecutado correctamente. Se ha creado el nuevo archivo en la ruta: "+ data.toString());
        System.exit(0);
    }
    
    public void printVigenereLengthOne(){
        System.out.println("La longitud de la clave ha de ser mayor a 1.");
        System.exit(0);
    }
    public void printVigenereSameCharactersInKey(){
        System.out.println("La clave no puede estar formada por un único caracter.");
        System.exit(0);  
    }
}
