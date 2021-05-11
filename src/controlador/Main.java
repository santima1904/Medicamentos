package controlador;

import clasesBasicas.Medicamento;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        final String CLASE = "C:\\Users\\smartinez\\Desktop\\Programacion\\Ficheros\\Medicamentos";
        final String CASA = "C:\\Users\\TESTER\\Desktop\\programacion\\Medicamentos";

        LocalDate fecha = LocalDate.of(2021, 3, 5);
        Medicamento m = new Medicamento();

        FileAccess.crearFichero(".");
        FileAccess.escribir("fichero.txt", m);
        FileAccess.leerFichero("fichero.txt");
    }
}
