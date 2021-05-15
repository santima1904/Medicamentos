package controlador;

import clasesBasicas.Epi;
import clasesBasicas.Medicamento;
import clasesBasicas.Producto;
import enums.ParteCuerpo;
import enums.Presentacion;
import gestion.FileAccessObjects;
import gestion.Gestora;
import vista.Mensajes;


import java.io.File;
import java.time.LocalDate;
import java.util.List;



public class Main {

    private static void insertarListaOrdenada(List<Producto> productos){
        FileAccessObjects.borrarFichero();

        for (Producto p:productos) {
            FileAccessObjects.escribirProducto(p);
        }
    }

    public static void main(String[] args) {

        final String CLASE = "C:\\Users\\smartinez\\Desktop\\Programacion\\Ficheros\\Medicamentos";
        final String CASA = "C:\\Users\\TESTER\\Desktop\\programacion\\Medicamentos";


        List<Producto> lista;

        LocalDate fecha = LocalDate.of(2021, 3, 5);

        Medicamento m1 = new Medicamento("1", "primero", fecha, 10, Presentacion.C, "primero");
        Medicamento m2 = new Medicamento("2", "segundo", fecha, 10, Presentacion.C, "primero");
        Epi e1 = new Epi("3", "tercero", fecha, 10, ParteCuerpo.O, "si");
        Epi e2 = new Epi("4", "cuarto", fecha, 10, ParteCuerpo.O, "si");


        System.out.println("------------ borrar fichero ------------");
        FileAccessObjects.borrarFichero();
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
        lista = FileAccessObjects.leerFichero();
        lista = Gestora.ordenar(lista);
        Mensajes.mostrarLista(lista);

    }
}
