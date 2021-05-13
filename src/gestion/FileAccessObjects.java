/**
 * Clase para controlar los ficheros con objetos, realizar todas las acciones con ellos
 */

package gestion;

import clasesBasicas.Producto;


import java.io.*;
import java.util.*;

public class FileAccessObjects {

    //TODO booleanos en las excepciones para mostrar mensajes, cambiar el e. printStack por boolean = false
    //TODO metodo para validar en el fichero que no hay un objeto con el codigo dado
    //TODO cambiar inserccion para que sea producto a pruducto(cambiar sobreescribirFichero)
    //TODO Hacerlo con fichero de movimiento sin consolidar datos
    //TODO para borrar  un producto en un fichero, hace falta fichero auxiliar


    /**
     * Cabecera: public static void crearFichero()
     * Precondiciones: ninguna
     * Entradas: ninguna
     * Salida: niunguna
     * Postcondiciones: fichero creaado
     */
    public static void crearFichero(String nombre){

        File fichero = new File (nombre);//introduzco el nombre del fichero a crear

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
        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        List<Producto> productos = new ArrayList<>(); //creo una lista para insertar los productos del fichero

        try {
            ois = new ObjectInputStream(new FileInputStream(nombre));//creo el ObjectInputStream y el fileinputStream con el nombre del archivo, para poder leer el contenido del fichero

            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();

            // Mientras haya objetos
            while (aux != null) {
                try{
                    if (aux instanceof Producto)//mientras el objeto sea una instancia de Producto, porque quiero solo los productos
                       productos.add((Producto) aux);  // guardo el producto previamente leido en una lista

                    aux = ois.readObject();//leo el siguiente
                }catch (EOFException e){
                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }
        }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

        } finally{
            try {
                assert ois != null;
                ois.close();//cierro el objectInputStream
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }
        return productos;//devuelvo la lista de productos
    }

    /**
     * Cabecera: public static void escribirProducto()
     * Precondiciones: fichero creado
     * Entradas: String nombre, producto p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero
     */
    public static void escribirProducto(String nombre, Producto p) {
        File fichero = new File(nombre);//guardo el espacio indicado para el archivo

        ObjectOutputStream oos = null;//Instancio el ObjectOutputStream y lo pongo a nulo

        try {
            if (fichero.exists()){//si el fichero existe
                oos = new MyObjectOutputStream(new FileOutputStream(nombre, true));//uso mi propio ObjectOutputStream para no sobreescribir los productos, simplemente añadirlos
            }else{
                fichero.createNewFile();//si no esta creado, lo creo
                oos = new ObjectOutputStream(new FileOutputStream(nombre, true));//uso el ObjectOutputStream de java para escribir en un fichero nuevo
            }

            oos.writeObject(p);//escribo el objeto en  el fichero

        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
        finally {
            cerrarObjectOutput(oos);//llamo al metodo para cerrar el ObjectOutputStream
        }

    }

    /**
     * Cabecera: public static void sobreescribirLista(String nombre, List<Producto> p)
     * Precondiciones: fichero creado
     * Entradas: String nombre, producto p
     * Salida: niunguna
     * Postcondiciones: Inserta  los objetos de la lista  en el fichero
     */
    public static void sobreescribirLista(String nombre, List<Producto> lista) {
        File fichero = new File(nombre);//guardo el espacio indicado para el archivo

        ObjectOutputStream oos = null;//Instancio el ObjectOutputStream y lo pongo a nulo

        try {

            oos = new ObjectOutputStream(new FileOutputStream(nombre));//uso el ObjectOutputStream de java para escribir en un fichero nuevo

            for (Producto p: lista) {//recorro la lista
                oos.writeObject(p);//escribo cada producto de la lista en el fichero
            }


        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace(); //muestro la excepcion
        }
        finally {
            cerrarObjectOutput(oos);//llamo al metodo para cerrar el ObjectOutputStream
        }

    }

    /**
     * Cabecera: private void cerrarObjectOutput(ObjectOutputStream oos)
     * Precondiciones: ObjectOutputStream credo
     * Entradas: ObjectOutputStream oos
     * Salida: niunguna
     * Postcondiciones: cierra el oos
     */
    public static void cerrarObjectOutput(ObjectOutputStream oos){
        try {
            assert oos != null;
            oos.close();  // Se cierra al terminar.
        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
    }


    /**
     * Cabecera: private void borrarFichero(String nombre)
     * Precondiciones:fichero creado
     * Entradas: String nombre
     * Salida: niunguna
     * Postcondiciones: borra el fichero
     */
    public static void borrarFichero(String nombre){
        File fichero = new File(nombre);
        fichero.delete();//metodo de la clase file para borrar el fichero
    }


}
