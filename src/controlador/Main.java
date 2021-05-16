package controlador;

import clasesBasicas.Epi;
import clasesBasicas.Medicamento;
import clasesBasicas.Producto;
import enums.ParteCuerpo;
import enums.Presentacion;
import gestionFicheros.FileAccessObjects;
import gestionFicheros.FileAccessText;
import vista.Mensajes;


import java.time.LocalDate;
import java.util.List;



public class Main {

    private static void insertarListaOrdenada(List<Producto> productos){
        FileAccessObjects.borrarFichero(FileAccessObjects.NOMBRE_DIRECTO);

        for (Producto p:productos) {
            FileAccessObjects.escribirProducto(p);
        }
    }

    public static void main(String[] args) {

         final String NOMBRE_DIRECTO = "Antipandemia.txt";
         final String NOMBRE_MOVIMIENTO = "AntipandemiaAux.txt";
         final String AUXILIAR = "Aux2.txt";


        LocalDate fecha = LocalDate.of(2021, 3, 5);
        ///* Menu pocho pa probar
        final String CLASE = "C:\\Users\\smartinez\\Desktop\\Programacion\\Ficheros\\Medicamentos";
        final String CASA = "C:\\Users\\TESTER\\Desktop\\programacion\\Medicamentos";


        List<Producto> lista;



        Medicamento m1 = new Medicamento("1", "primero", fecha, 10, Presentacion.C, "primero");
        Medicamento m2nuevo = new Medicamento("2", "primero", fecha, 50, Presentacion.C, "primero");
        Medicamento m2 = new Medicamento("2", "segundo", fecha, 10, Presentacion.C, "primero");
        Epi e1 = new Epi("3", "tercero", fecha, 10, ParteCuerpo.O, "si");
        Epi e2 = new Epi("4", "cuarto", fecha, 10, ParteCuerpo.O, "si");


        /*Binario
        System.out.println("------------ borrar fichero ------------");
        FileAccessObjects.borrarFichero(NOMBRE_DIRECTO);
        FileAccessObjects.borrarFichero(AUXILIAR);
        System.out.println("------------ contenido fichero sin ordenar------------");
        FileAccessObjects.escribirProducto(m2);
        //FileAccessObjects.escribirProducto(NOMBRE, e1);
        FileAccessObjects.escribirProducto(m1);
        lista = FileAccessObjects.leerFichero();
        Mensajes.mostrarLista(lista);
        lista = Gestora.ordenar(lista);
        insertarListaOrdenada(lista);
        System.out.println("------------ contenido lista ordenado------------");
        Mensajes.mostrarLista(lista);
        System.out.println("------------ contenido fichero ordenado------------");
        lista = FileAccessObjects.leerFichero();
        Mensajes.mostrarLista(lista);
        System.out.println("------------ contenido fichero ordeando con nuevos productos------------");
        FileAccessObjects.escribirProducto(e1);
        FileAccessObjects.escribirProducto(e2);
        lista = FileAccessObjects.leerFichero();
        lista = Gestora.ordenar(lista);
        Mensajes.mostrarLista(lista);
        System.out.println("------------ borro producto 1------------");
        FileAccessObjects.borrarProducto("1");
        FileAccessObjects.cambiarNombre();
        lista = FileAccessObjects.leerFichero();
        lista = Gestora.ordenar(lista);
        Mensajes.mostrarLista(lista);
        System.out.println("------------ actualizar producto 1------------");
        FileAccessObjects.acttualizarProducto(m2nuevo);
        FileAccessObjects.cambiarNombre();
        lista = FileAccessObjects.leerFichero();
        lista = Gestora.ordenar(lista);
        Mensajes.mostrarLista(lista);

        */

        //Menu bien hecho
        /*
        do {

           // Validaciones.pedirFecha();
            Validaciones.pedirEnum();
            Mensajes.menuSalir();
        }while(Validaciones.pedirOpcion());


         */

        //Texto
        FileAccessText.escribir(m1);
        FileAccessText.escribir(m2);
        Mensajes.mostrarLista(FileAccessText.leerLinea());

    }
}
