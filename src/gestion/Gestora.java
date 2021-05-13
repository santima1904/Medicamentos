package gestion;

import clasesBasicas.Producto;

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
}
