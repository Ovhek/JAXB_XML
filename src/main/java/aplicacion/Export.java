/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Sacrificio;
import aplicacion.model.SacrificioPadre;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Cole
 */
public class Export {

    /**
     * Función encargada de ordenar los datos según el elemento especificado.
     * @param data Datos a ordenar
     * @param columnToOrderBy elemento del objeto sobre el cual ordenar
     * @return Objeto de tipo SacrificioPadre con la lista ordenada
     * @throws NoSuchMethodException 
     */
    public SacrificioPadre sort(SacrificioPadre data, String columnToOrderBy) throws NoSuchMethodException{
        //Listado de sacrificios
        List<Sacrificio> sacrificios = data.getSacrificios();

        //Obtenemos el metodo sobre el cual ordenar
        Method getterMethod = Sacrificio.class.getMethod("get" + columnToOrderBy);

        //Hacemos un sort de la lista con el metodo que hemos proporcionado
        sacrificios.sort(Comparator.comparing(d -> {
            try {
                return (Comparable) getterMethod.invoke(d);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println("Error: " + e.getMessage());
                return null;
            }
        }));
        
        //Creamos un nuevo objeto jaxb de tipo SacrifioPadre y le añadimos la lista ordenada
        SacrificioPadre sortedData = new SacrificioPadre();
        sortedData.setSacrificios((ArrayList<Sacrificio>) sacrificios);
        
        return sortedData;
    }
    
    /**
     * Función encargada de exportar un CSV según los datos ordenados
     * @param outputPath Ruta de destino
     * @param columnToOrderBy elemento sobre el cual ordenar
     * @param data Datos los cuales exportar
     * @throws NoSuchMethodException
     * @throws JAXBException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    public void exportCSV(String outputPath, String columnToOrderBy, SacrificioPadre data) throws NoSuchMethodException, JAXBException, IOException, InvocationTargetException, IllegalArgumentException, IllegalAccessException{
        SacrificioPadre sortedData = sort(data, columnToOrderBy);
        
        //Creamos el archivo de salida
        File outputFileCSV = new File(outputPath + ".csv");
        
        //Creamos el archivo CSV
        FileWriter csvWriter = new FileWriter(outputFileCSV);

        //Nombre de las columnas
        for (Method method : Sacrificio.class.getMethods()) {
            if (method.getName().startsWith("get") && !method.getName().contains("Class")) {
                csvWriter.append(method.getName().substring(3));
                csvWriter.append(",");
            }
        }
        csvWriter.append("\n");
        //Datos
        for (Sacrificio sacrificio : sortedData.getSacrificios()) {
            for (Method method : sacrificio.getClass().getMethods()) {
                if (method.getName().startsWith("get") && !method.getName().contains("Class")) {
                    Object invokeResult = method.invoke(sacrificio);
                    if (invokeResult != null) {
                        csvWriter.append(invokeResult.toString());
                    }
                    else{
                        csvWriter.append("");
                    }
                    csvWriter.append(",");

                }
            }
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }
    
    /**
     * Función encargada de exportar un XML según los datos ordenados
     * @param outputPath ruta de destino
     * @param columnToOrderBy elemento sobre el cual ordenar
     * @param data datos a ordenar
     * @throws NoSuchMethodException
     * @throws JAXBException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    public void exportXML(String outputPath, String columnToOrderBy, SacrificioPadre data) throws NoSuchMethodException, JAXBException, IOException, InvocationTargetException, IllegalArgumentException, IllegalAccessException{
        SacrificioPadre sortedData = sort(data, columnToOrderBy);
        File outputFileXML = new File(outputPath + ".xml");
        
        //Creamos el contexto jaxb y el marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(SacrificioPadre.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(sortedData, outputFileXML);
    }
    
    /**
     * Función encargada de ordenar los datos según el elemento y exportarlos tanto a XML como a CSV
     * @param outputPath ruta a la cual exportar
     * @param columnToOrderBy elemento sobre el cual ordenar
     * @param data Datos a ordenar
     * @throws NoSuchMethodException
     * @throws JAXBException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException 
     */
    public void exportCSVXML(String outputPath, String columnToOrderBy, SacrificioPadre data) throws NoSuchMethodException, JAXBException, IOException, InvocationTargetException, IllegalArgumentException, IllegalAccessException {
        SacrificioPadre sortedData = sort(data, columnToOrderBy);
        exportCSV(outputPath, columnToOrderBy, data);
        exportXML(outputPath, columnToOrderBy, data);

    }
}
