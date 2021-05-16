package controlador;

import clasesBasicas.*;

import enums.Presentacion;
import gestionFicheros.FileAccessText;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gestora {

    /**
     * Cabecera: public static void ordenar()
     * Precondiciones: lista cargada y creada
     * Entradas: Lista de productos
     * Salida: lista de productos
     * Postcondiciones: Ordena la lista con los elementos del fichero
     */
    public static List<Producto> ordenar(List<Producto> productos){

        Collections.sort(productos);

        return productos;
    }



    //TODO HACERLO TODO EN METODO LEER PARA HACERLO EN BUCLE
    //TODO MOVER METODOS A FILEACCES
}
