package vista;

import clasesBasicas.Producto;

import java.util.List;

public class Mensajes {

    //Constantes con mensajes
    public static final String MENU = "";
    public static final String SALIR = "Desea seguir: " +"\n"
            +"1. Si"+"\n"+"2.No";

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

    /**
     * Cabecera: public void mostrar menu()
     * Descripcion: mostrar menu por pantalla
     */

    public static void mostrarMenu(){
        System.out.println(MENU);
    }

    /**
     * Cabecera: public void mostrar menu()
     * Descripcion: mostrar menu por pantalla
     */

    public static void menuSalir(){
        System.out.println(SALIR);
    }
}
