/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author gilio
 */
public class Gestor {

    public String leerArchivo1(String linea) {

        try {
            linea = new String();
            try (FileReader ruta = new FileReader("archivos/archivo1.txt");
                    BufferedReader in_arch = new BufferedReader(ruta)) {

                while (in_arch.readLine() != null) {
                    linea = in_arch.readLine();
                    System.out.println(linea);
                }

            }
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo.");
        }
        return linea;

    }

    public String leerArchivo2(String ruta) {

        Path archivo = Paths.get(ruta);
        String texto = "";

        try {
            texto = new String(Files.readAllBytes(archivo));
            System.out.println("El contenido del archivo es:\n" + texto.replaceAll("[\n\r]", ""));
            System.out.println();
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido."); // El archivo no se lee pues bien no existe o la ruta está mal escrita.
        }
        return texto;

    }

}
