package controlador;

import clasesBasicas.Epi;
import clasesBasicas.Medicamento;
import clasesBasicas.Producto;
import enums.ParteCuerpo;
import enums.Presentacion;
import vista.Mensajes;

import javax.swing.*;
import java.io.File;
import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        final String CLASE = "C:\\Users\\smartinez\\Desktop\\Programacion\\Ficheros\\Medicamentos";
        final String CASA = "C:\\Users\\TESTER\\Desktop\\programacion\\Medicamentos";
        final String NOMBRE = "Antipandemia.txt";

        List<Producto> lista;

        LocalDate fecha = LocalDate.of(2021, 3, 5);

        Medicamento m1 = new Medicamento("1", "primero", fecha, 10, Presentacion.C, "primero");
        Medicamento m2 = new Medicamento("2", "segundo", fecha, 10, Presentacion.C, "primero");
        Epi e1 = new Epi("3", "tercero", fecha, 10, ParteCuerpo.O, "si");
        Epi e2 = new Epi("4", "cuarto", fecha, 10, ParteCuerpo.O, "si");



        FileAccessObjects.escribir(NOMBRE, m2);
        FileAccessObjects.escribir(NOMBRE, e1);
        FileAccessObjects.escribir(NOMBRE, m1);
        FileAccessObjects.escribir(NOMBRE, e2);
        lista = FileAccessObjects.leerFichero(NOMBRE);
        Mensajes.mostrarLista(lista);
        lista = FileAccessObjects.ordenar(lista);
        System.out.println("------------");
        Mensajes.mostrarLista(lista);
    }
}
