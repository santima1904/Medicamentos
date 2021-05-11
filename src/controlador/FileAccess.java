/**
 * Clase para controlar los ficheros, realizar todas las acciones con ellos
 */

package controlador;

import java.io.File;
import java.io.IOException;

public class FileAccess {

    //crear fichero
    public static void crearFichero(){
        File fichero = new File ("C:\\Users\\smartinez\\Desktop\\Programacion\\Ficheros\\Medicamentos","fichero.txt");
        //fichero.renameTo(new File("ruta", nuevo nombre)) para renombrar el fichero
        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //leer fichero


    //escribir en fichero



}
