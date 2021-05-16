package gestionFicheros;

import clasesBasicas.Medicamento;
import clasesBasicas.Producto;
import enums.Presentacion;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class FileAccessText {

    private static File fichero;

    public static final String NOMBRE = "Antipandemia.txt";


    /**
     * Cabecera: public static void escribir()
     * Precondiciones: fichero creado
     * Entradas: producto p
     * Salida: niunguna
     * Postcondiciones: Inserta el objeto p en el fichero
     */
    public static void escribir(Producto p){
        fichero = new File(NOMBRE);
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(fichero, true));

            bw.write((p.toString()));
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



    /**
     * Cabecera: public static void leerLinea()
     * Precondiciones: fichero creado
     * Entradas: ninguno
     * Salida: array con los atributos del objeto a crear
     * Postcondiciones: Devuelve una array con los atributos para convertirlo a objeto posteriormente
     */

    public static List<Producto> leerLinea(){
        fichero = new File(NOMBRE);
        BufferedReader br = null;
        String linea = null;
        String [] lineaProducto = null;
        List<Producto> lista = new ArrayList<>();
        Producto p = null;

        try {
            br = new BufferedReader(new FileReader(fichero));

            do{
                linea = br.readLine();
                if(linea!=null){
                    lineaProducto = linea.split(",");
                    p = crearObjeto(lineaProducto);
                    lista.add(p);
                }

            }while(linea!=null);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }



    /**
     * Cabecera: public static void ordenar()
     * Precondiciones: array cargada y creada
     * Entradas: String [] atributos
     * Salida: Producto p
     * Postcondiciones: Crea un objeto apartir de la array dada
     */
    private static Producto crearObjeto(String[] atributos){
        Producto producto = null;

        if (atributos[0].equals("Medicamento")){
            producto = new Medicamento(atributos[1], atributos[2], LocalDate.parse(atributos[3]), Double.parseDouble(atributos[4]), Presentacion.valueOf(atributos[5]), atributos[6]);
            //}else{
            //  producto = new Epi(atributos[1], atributos[2], LocalDate.parse(atributos[3]), Double.parseDouble(atributos[4]), Presentacion.valueOf(atributos[5]), atributos[6]);
        }

        return producto;
    }
}
