package controlador;

import clasesBasicas.Medicamento;
import vista.Mensajes;

import java.io.File;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        final String CLASE = "C:\\Users\\smartinez\\Desktop\\Programacion\\Ficheros\\Medicamentos";
        final String CASA = "C:\\Users\\TESTER\\Desktop\\programacion\\Medicamentos";
        final String NOMBRE = "Antipandemia.txt";


        LocalDate fecha = LocalDate.of(2021, 3, 5);
        Medicamento m = new Medicamento();

        FileAccessObjects.crearFichero(".", NOMBRE);
        FileAccessObjects.escribir(NOMBRE, m);
        Mensajes.mostrarLista(FileAccessObjects.leerFichero(NOMBRE));
    }
}
