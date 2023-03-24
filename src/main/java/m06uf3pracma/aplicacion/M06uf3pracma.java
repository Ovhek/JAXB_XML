/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package m06uf3pracma.aplicacion;

import java.util.ArrayList;
import m06uf3pracma.Utils.CliManager;
import m06uf3pracma.dao.GenericDAO;
import m06uf3pracma.datos.CliDataLayer;
import java.util.List;
import m06uf3pracma.model.Directorio;
import m06uf3pracma.model.Documento;
import m06uf3pracma.model.Repositorio;
import org.apache.commons.cli.Options;
import m06uf3pracma.presentacion.CliPresentationLayer;
import org.bson.types.ObjectId;

/**
 * Clase Principal de la aplicación
 *
 * @author Cole
 */
public class M06uf3pracma {

    /**
     * Funció que se ejecuta al ejecutar la aplicación
     *
     * @param args argumentos del usuario al ejecutar la aplicación
     */
    public static void main(String[] args) {

        GenericDAO<Repositorio> dao = new GenericDAO<>(Repositorio.class);

        Directorio directorio = new Directorio();
        directorio.setRuta("/home/usuario/mis_documentos");
        // Agregar documentos y directorios al objeto directorio...
        Documento documento = new Documento();
        documento.setNombre("archivo.txt");
        directorio.setDocumentos(new ArrayList<>());
        directorio.setDirectorios(new ArrayList<>());
        // Crear un objeto de tipo Directorio
        Repositorio repo = new Repositorio();
        repo.setNombre("Hola");

        repo.setRaiz(directorio);


        // Guardar el objeto directorio en la base de datos
        dao.save(repo);

        // Actualizar el objeto directorio
        directorio.setRuta("/home/usuario/nuevos_documentos");
        
        repo = dao.getById(new ObjectId("641b986e3182212af5f36812"));
        repo.setNombre("test10");
        dao.update(repo);

        // Eliminar el objeto directorio
        //dao.delete(repo);

        // Obtener una lista de todos los objetos de tipo Directorio en la base de datos
        List<Repositorio> repos = dao.getAll();
        CliManager manager = new CliManager();
        CliPresentationLayer presentation = new CliPresentationLayer();

        if (args.length < 1) {
            presentation.printMainHelper();
            System.exit(0);
        }

        Options options = null;
        //Comprobar el primer argumento --> report, export, import, decrypt o encrypt
        switch (args[0].toLowerCase()) {
            case "create" ->
                options = manager.getCreateOptions();
            case "drop" ->
                options = manager.getDropOptions();
            case "push" ->
                options = manager.getPushOptions();
            case "pull" ->
                options = manager.getPullOptions();
            case "compare" ->
                options = manager.getCompareOptions();
            case "clone" ->
                options = manager.getCloneOptions();
            default ->
                presentation.printMainHelper();
        }

        presentation = new CliPresentationLayer(options, args[0]);
        CliDataLayer data = new CliDataLayer(args, options);
        CliLogic logic = new CliLogic(presentation, data);
        logic.processData();
    }
}
