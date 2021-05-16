/**
 * Clase para controlar los ficheros con objetos, realizar todas las acciones con ellos
 */

package gestionFicheros;

import clasesBasicas.Producto;


import java.io.*;
import java.util.*;

public class FileAccessObjects {

    //TODO booleanos en las excepciones para mostrar mensajes, cambiar el e. printStack por boolean = false
    //TODO Hacerlo con fichero de movimiento sin consolidar datos

    public static final String NOMBRE_DIRECTO = "Antipandemia.txt";
    public static final String NOMBRE_MOVIMIENTO = "AntipandemiaAux.txt";
    public static final String AUXILIAR = "Aux2.txt";


    /**
     * Cabecera: public static void crearFichero()
     * Precondiciones: ninguna
     * Entradas: ninguna
     * Salida: niunguna
     * Postcondiciones: fichero creaado
     */
    public static void crearFichero(){

        File fichero = new File (NOMBRE_DIRECTO);//introduzco el nombre del fichero a crear

        try {
            fichero.createNewFile();//creo el fichero

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Cabecera: public static void leerFichero()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: lista de objetos producto
     * Postcondiciones: Devuelve una lista con los contenidos de los objetos del fichero
     */
    public static List<Producto> leerFichero(){
        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        List<Producto> productos = new ArrayList<>(); //creo una lista para insertar los productos del fichero

        try {
            ois = new ObjectInputStream(new FileInputStream(NOMBRE_DIRECTO));//creo el ObjectInputStream y el fileinputStream con el nombre del archivo, para poder leer el contenido del fichero

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
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }
        return productos;//devuelvo la lista de productos
    }

    /**
     * Cabecera: public static void escribirProducto()
     * Precondiciones: fichero creado
     * Entradas: producto p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero
     */
    public static void escribirProducto(Producto p) {
        File fichero = new File(NOMBRE_DIRECTO);//guardo el espacio indicado para el archivo

        ObjectOutputStream oos = null;//Instancio el ObjectOutputStream y lo pongo a nulo

        try {
            if (fichero.exists()){//si el fichero existe
                oos = new MyObjectOutputStream(new FileOutputStream(NOMBRE_DIRECTO, true));//uso mi propio ObjectOutputStream para no sobreescribir los productos, simplemente añadirlos
            }else{
                fichero.createNewFile();//si no esta creado, lo creo
                oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_DIRECTO, true));//uso el ObjectOutputStream de java para escribir en un fichero nuevo
            }

            oos.writeObject(p);//escribo el objeto en  el fichero

        } catch (IOException e) {//si salta la excepcion  IOException
            e.printStackTrace();//muestro la excepcion
        }
        finally {
            if (oos != null) {
                cerrarObjectOutput(oos);//llamo al metodo para cerrar el ObjectOutputStream
            }
        }

    }


    /**
     * Cabecera: public static void borrarProducto(String codigoBarras)
     * Precondiciones: fichero creado
     * Entradas:  String codigoBarras
     * Salida: niunguna
     * Postcondiciones: Borra el objeto p en el fichero cojn el codigo igual al dado
     */

    public static void borrarProducto(String codigoBarras){
        File fichero = new File(NOMBRE_DIRECTO);
        File ficheroaUX = new File(AUXILIAR);

        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        ObjectOutputStream oos = null ;//Instancio el ObjectOutputStream y lo pongo a nulo

        try{
            ficheroaUX.createNewFile();

            ois = new ObjectInputStream(new FileInputStream(NOMBRE_DIRECTO));//uso el ObjectInputStream de java para leer en fichero

            oos = new ObjectOutputStream(new FileOutputStream(AUXILIAR));//uso el ObjectOutputStream de java para escribir en un fichero nuevo


            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();


            while (aux != null) {//mientras haya objetos
                try{
                    if (aux instanceof Producto && !((Producto) aux).getCodigoBarras().equals(codigoBarras)) {//mientras el objeto sea una instancia de Producto, porque quiero solo los productos
                        //y mientras el codigo de barras dado no sea igual que el del objeto leido, para no grabar el que queremos borrar

                        oos.writeObject(aux);//escribo el objeto en  el fichero
                    }
                    aux = ois.readObject();//leo el siguienteº

                }catch (EOFException e){
                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally{

            if (oos != null) {
                cerrarObjectOutput(oos);//cierro el objectOutputStream
            }

            try {
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
        }

    }


    /**
     * Cabecera: public static void actualizarProducto(String codigoBarras)
     * Precondiciones: fichero creado
     * Entradas:  Producto modificao
     * Salida: niunguna
     * Postcondiciones: Borra el objeto p en el fichero cojn el codigo igual al dado
     */
    public static void acttualizarProducto(Producto modificao){
        File fichero = new File(NOMBRE_DIRECTO);
        File ficheroaUX = new File(AUXILIAR);

        ObjectInputStream ois = null; //Instancio el ObjectInputStream y lo pongo a nulo
        ObjectOutputStream oos = null ;//Instancio el ObjectOutputStream y lo pongo a nulo

        try{
            ficheroaUX.createNewFile();

            ois = new ObjectInputStream(new FileInputStream(NOMBRE_DIRECTO));

            oos = new ObjectOutputStream(new FileOutputStream(AUXILIAR));//uso el ObjectOutputStream de java para escribir en un fichero nuevo


            //Instancio un objeto a nulo
            Object aux = null;
            // Se lee el primer objeto
            aux = ois.readObject();


            while (aux != null) {
                try{
                    if (aux instanceof Producto) {//mientras el objeto sea una instancia de Producto, porque quiero solo los productos

                        if (((Producto) aux).getCodigoBarras().equals(modificao.getCodigoBarras())){
                            oos.writeObject(modificao);
                        }else{
                            oos.writeObject(aux);//escribo el objeto en  el fichero
                        }
                    }
                    aux = ois.readObject();//leo el siguienteº

                }catch (EOFException e){
                    aux = null;//si salta la excepcion, pongo el objeto a nulo para salir del bucle
                }

            }


        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        } finally{

            if (oos != null) {
                cerrarObjectOutput(oos);//cierro el objectOutputStream
            }

            try {
                if (ois != null) {
                    ois.close();//cierro el objectInputStream
                }
            } catch (IOException e) {//si salta la excepcion  IOException
                e.printStackTrace();//muestro la excepcion
            }
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
        File fichero = new File(NOMBRE_DIRECTO);
        fichero.delete();//metodo de la clase file para borrar el fichero

    }


    /**
     * Cabecera: public static void cambiarFichero()
     * Precondiciones:fichero creado
     * Entradas: ninguna
     * Salida: niunguna
     * Postcondiciones: renombra el fichero auxiliar, con el nokmbre del anterior para guardar los cambios y conservar el nombre del archivo origial
     */
    public static void cambiarNombre() {
        File fichero = new File(NOMBRE_DIRECTO);
        File ficheroaUX = new File(AUXILIAR);
        File master = fichero;

        fichero.delete();//borro el fichero inicial
        ficheroaUX.renameTo(master);//renombro el auxiliar con los cambios guardados al master, que tiene la referencia del anterior

    }

}
