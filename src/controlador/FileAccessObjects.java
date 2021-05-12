/**
 * Clase para controlar los ficheros con objetos, realizar todas las acciones con ellos
 */

package controlador;

import clasesBasicas.Producto;


import java.io.*;
import java.util.*;

public class FileAccessObjects {


    /**
     * Cabecera: public static void crearFichero()
     * Precondiciones: ninguna
     * Entradas: ninguna
     * Salida: niunguna
     * Postcondiciones: fichero creaado
     */
    public static void crearFichero(String ruta, String nombre){

        File fichero = new File (ruta, nombre);//introduzco la ruta y el nombre del fichero a crear

        try {
            fichero.createNewFile();//creo el fichero

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Cabecera: public static void leerFichero()
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: lista de objetos producto
     * Postcondiciones: Devuelve una lista con los contenidos de los objetos del fichero
     */
    public static List<Producto> leerFichero(String nombre){
        ObjectInputStream ois = null;
        List<Producto> productos = new ArrayList<>();

        try {
            ois = new ObjectInputStream(new FileInputStream(nombre));
            // Se lee el primer objeto
            Object aux = null;

            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {
                try{
                    if (aux instanceof Producto)
                       productos.add((Producto) aux);  // Lo guardo en una lista para printarlo despues

                    aux = ois.readObject();
                }catch (EOFException e){
                    aux = null;
                }

            }
        }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

        } finally{
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return productos;
    }

    /**
     * Cabecera: public static void escribirFichero()
     * Precondiciones: fichero creado
     * Entradas: String nombre, producto p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero
     */
    public static void escribir(String nombre, Producto p) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(nombre));
            oos.writeObject(p);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert oos != null;
                oos.close();  // Se cierra al terminar.
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * Cabecera: public static void ordenarFichero()
     * Precondiciones: fichero creado
     * Entradas: Lista de productos
     * Salida: lista de productos
     * Postcondiciones: Ordena el fichero
     */
    public static List<Producto> ordenar(List<Producto> productos){

        Collections.sort(productos);

        return productos;
    }


}
