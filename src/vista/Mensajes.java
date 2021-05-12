package vista;

import clasesBasicas.Producto;

import java.util.List;

public class Mensajes {

    /**
     * Cabecera: public static void mostrarLista(Lista p)
     * Precondiciones: lista creada
     * Entrada: lista de productos
     * Salida: ninguna
     * Postcondiciones: Muestra por pantalla el contenido de la lista
     */

    public static void mostrarLista(List<Producto> p){

        for (Producto objeto: p) {
            System.out.println(objeto);
        }
    }
}
