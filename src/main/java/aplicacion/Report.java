/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;

import aplicacion.model.Sacrificio;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Clase que maneja la logica del comando Report
 *
 * @param lista Lista de sacrificios obtenida del xml en forma de objeto.
 * @author joseb
 */
public class Report {

    private List<Sacrificio> lista;

    /**
     * Constructor de Report
     *
     * @param lista Lista de sacrificios obtenida del xml en forma de objeto.
     */
    public Report(List<Sacrificio> lista) {
        this.lista = lista;
    }

    /**
     * Funcion Report Procesa y filtra los datos para crear el informe
     *
     * @return Informe que indica las especies y razas sacrificadas.
     */
    public String report_0() {

        //Mapa que contiene las especies y su cantidad.
        Map<String, Integer> map_esp = new HashMap<>();

        //Mapa que relacion las especies con la las razas pertenecientes
        //y su cantidad.
        Map<String, Map<String, Integer>> map_espraz = new HashMap<>();

        //Recoremos la lista de sacrificios para completar los mapas.
        lista.forEach(s -> {

            //Obtenemos la especie del sacrificio actual
            String especie = s.getEspecie();

            /*
             * Aumentamos el contador +1. En caso de que no exista la especie la
             * insertamos el mapa de especies.
             */
            map_esp.put(especie, map_esp.getOrDefault(especie, 0) + 1);

            //Obtenemos la raza del saccrificio actual
            String raza = s.getRaza();

            //Obtenemos el mapa de razas de la especia actual
            Map<String, Integer> map_razasTipo = map_espraz.get(especie);

            /*
             * Comprovamos que el mapa de especies y razas contenga un mapa de
             * razas. En caso de no conetener creamos un nuevo mapra de razas y
             * lo insertamos.
             */
            if (map_razasTipo == null) {
                map_razasTipo = new HashMap<>();
                map_espraz.put(especie, map_razasTipo);
            }

            /*
             * Aumentamos el contador +1. En caso de que no exista la raza la
             * insertamos el mapa de razas.
             */
            map_razasTipo.put(raza, map_razasTipo.getOrDefault(raza, 0) + 1);
        }
        );
        //Llamamos a la funcion para generar el informe con los datos procesados
        //Devolvemos el string informe generador por la funcion.
        return generarInforme_0(map_esp, map_espraz);

    }

    /**
     * Funcion generarInforme_0 Genera un informe con los datos filtrados y
     * procesados de la lista.
     *
     * @param map_esp Mapa de especies y cantidad existente de cada una.
     * @param map_espraz Mapa que relaciona las especies y las razas que
     * contiene.
     * @return
     */
    private String generarInforme_0(Map<String, Integer> map_esp, Map<String, Map<String, Integer>> map_espraz) {

        String informe = "";

        //Recoremos el mapa de especies mediante un iterador.
        Iterator i = map_esp.entrySet().iterator();

        while (i.hasNext()) {

            //Obtenemos el elemento del mapa (Especie&&Cantidad)
            Map.Entry<String, Integer> entry = (Map.Entry) i.next();
            String especie = entry.getKey();

            int esp_cantidad = entry.getValue();

            //Añadimos la informacion al informe
            informe += especie + " (" + esp_cantidad + "):\n";

            //Obtenemos el mapa de razas de la especie y lo recorremos con un
            //iterador.
            Map<String, Integer> map_razas = map_espraz.get(especie);
            Iterator j = map_razas.entrySet().iterator();

            while (j.hasNext()) {
                //Obtenos el elemento del mapa (raza&&cantidad)
                Map.Entry<String, Integer> jentry = (Map.Entry) j.next();
                String raza = jentry.getKey();

                int raza_cantidad = jentry.getValue();

                //Añadimos la informacion al informe
                informe += "\t" + raza + " (" + raza_cantidad + ")\n";
            }
        }
        return informe;
    }

    /**
     * Funcion generarInforme_2 Genera el informe con los datos procesados y
     * filtrados.
     *
     * @param map_municipios
     * @param map_munMataderos
     * @return el informe
     */
    private String generarInforme_2(Map<String, Integer> map_municipios, Map<String, Map<String, Integer>> map_munMataderos) {

        String informe = "";
        Iterator i = map_municipios.entrySet().iterator();

        while (i.hasNext()) {

            Map.Entry<String, Integer> entry = (Map.Entry) i.next();
            String municipio = entry.getKey();

            int municipio_cantidad = entry.getValue();

            Map<String, Integer> map_mataderos = map_munMataderos.get(municipio);
            int cantidad_mataderosMun = map_mataderos.size();
            informe += municipio + " (" + cantidad_mataderosMun + ") " + " (" + municipio_cantidad + "):\n";
            Iterator j = map_mataderos.entrySet().iterator();
            while (j.hasNext()) {

                Map.Entry<String, Integer> jentry = (Map.Entry) j.next();
                String matadero = jentry.getKey();

                int matadero_cantidad = jentry.getValue();
                informe += "\t" + matadero + " (" + matadero_cantidad + ")\n";
            }
        }
        return informe;
    }

    /**
     * Funcion report_1 Procesa y filtra los datos de la lista de sacrificios,
     * para generar el informe 1.
     *
     * @return Informe
     */
    public String report_1() {
        String informe = "";
        int machos = 0;
        int hembras = 0;
        Iterator<Sacrificio> i = lista.iterator();

        while (i.hasNext()) {
            String sexo = i.next().getSexo();
            if (sexo.equals("Hembra")) {
                hembras++;
            } else {
                machos++;
            }
        }
        int total = machos + hembras;
        double ph = (double) ((hembras * 100) / total);
        double pm = (double) ((machos * 100) / total);
        informe = "Machos sacrificados (" + pm + "%)\nHembras sacrificadas (" + ph + "%)\n";
        return informe;
    }

    /**
     * Funcion report_2 Procesa y filtra los datos para generar el informe_2
     *
     * @return Informe
     */
    public String report_2() {
        // Un mapa que contiene el nombre de la especie y un mapa de sus razas
        Map<String, Integer> map_municipios = new HashMap<>();
        Map<String, Map<String, Integer>> map_munMataderos = new HashMap<>();

        lista.forEach(s -> {
            String municipio = s.getMunicipio();
            /**
             * Aumentamos el contador +1 En caso de que no exista la especie la
             * insertamos
             */
            map_municipios.put(municipio, map_municipios.getOrDefault(municipio, 0) + 1);
            String maradero = s.getCodRegaMatadero();
            Map<String, Integer> map_mataderos = map_munMataderos.get(municipio);
            if (map_mataderos == null) {
                map_mataderos = new HashMap<>();
                map_munMataderos.put(municipio, map_mataderos);
            }
            map_mataderos.put(maradero, map_mataderos.getOrDefault(maradero, 0) + 1);
        }
        );
        return generarInforme_2(map_municipios, map_munMataderos);
    }

    /**
     * Exporta el informe a txt en la ruta indicada.
     *
     * @param ruta Dirección donde se exportara el archivo.
     * @param informe Informe que se exportara.
     */
    public void exportar(String ruta, String informe) {

        //Creamos un BufferedWriter en el try para que se cirre automaticamente.
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta))) {

            //Escribimos en el archivo el informe
            bufferedWriter.write(informe);

        } catch (IOException e) {
            System.out.println("Error al exportar el informe: " + e.getMessage());
        }
    }

}
