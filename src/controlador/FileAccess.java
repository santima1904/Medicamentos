/**
 * Clase para controlar los ficheros, realizar todas las acciones con ellos
 */

package controlador;

import clasesBasicas.Producto;
import com.sun.source.tree.TryTree;

import java.io.*;

public class FileAccess {


    /**
     * Cabecera: public static void crearFichero()
     * Precondiciones: ninguna
     * Entradas: ninguna
     * Salida: niunguna
     * Postcondiciones: fichero creaado
     */
    public static void crearFichero(String ruta){
        File fichero = new File (ruta, "AntiPandemia.txt");
        //fichero.renameTo(new File("ruta", nuevo nombre)) para renombrar el fichero
        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Cabecera: public static void leerFichero()
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: Muestra los contenidos de los objetos del fichero
     */
    public static void leerFichero(String nombre){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(nombre));
            // Se lee el primer objeto
            Object aux = null;

            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {
                try{
                    if (aux instanceof Producto)
                        System.out.println(aux);  // Se escribe en pantalla el objeto

                    aux = ois.readObject();
                }catch (EOFException e){
                    aux = null;
                }

            }
        }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

        } finally{
            assert ois != null;
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                oos.close();  // Se cierra al terminar.
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * Cabecera: public static void ordenarFichero()
     * Precondiciones: fichero creado
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: Ordena el fichero
     */
    public static void ordenar(String nombre){

    }


}
