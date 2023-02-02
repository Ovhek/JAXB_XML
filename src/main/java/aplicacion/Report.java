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
 *
 * @author joseb
 */
public class Report {

    private List<Sacrificio> lista;

    public Report(List<Sacrificio> lista) {
        this.lista = lista;
    }

    public String report_0() {
        // Un mapa que contiene el nombre de la especie y un mapa de sus razas
        Map<String, Integer> map_esp = new HashMap<>();
        Map<String, Map<String, Integer>> map_espraz = new HashMap<>();

        lista.forEach(s -> {
            String especie = s.getEspecie();
            /**
             * Aumentamos el contador +1 En caso de que no exista la especie la
             * insertamos
             */
            map_esp.put(especie, map_esp.getOrDefault(especie, 0) + 1);
            String raza = s.getRaza();

            Map<String, Integer> map_razasTipo = map_espraz.get(especie);
            if (map_razasTipo == null) {
                map_razasTipo = new HashMap<>();
                map_espraz.put(especie, map_razasTipo);
            }
            map_razasTipo.put(raza, map_razasTipo.getOrDefault(raza, 0) + 1);
        }
        );

        return generarInforme_0(map_esp, map_espraz);

    }

    private String generarInforme_0(Map<String, Integer> map_esp, Map<String, Map<String, Integer>> map_espraz) {

        String informe = "";
        Iterator i = map_esp.entrySet().iterator();

        while (i.hasNext()) {

            Map.Entry<String, Integer> entry = (Map.Entry) i.next();
            String especie = entry.getKey();

            int esp_cantidad = entry.getValue();
            informe += especie + " (" + esp_cantidad + "):\n";

            Map<String, Integer> map_razas = map_espraz.get(especie);
            Iterator j = map_razas.entrySet().iterator();

            while (j.hasNext()) {

                Map.Entry<String, Integer> jentry = (Map.Entry) j.next();
                String raza = jentry.getKey();

                int raza_cantidad = jentry.getValue();
                informe += "\t" + raza + " (" + raza_cantidad + ")\n";
            }
        }
        return informe;
    }

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

    public void exportar(String ruta, String informe) {
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta))) {
            bufferedWriter.write(informe);
        } catch (IOException e) {
            System.out.println("Error al exportar el informe: " + e.getMessage());
        }
    }

}
