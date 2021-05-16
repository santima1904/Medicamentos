package vista;

import enums.ParteCuerpo;

import java.time.*;
import java.util.Scanner;

import static java.time.temporal.ChronoField.*;

public class Validaciones {

    //Creo dos teclado
    public static Scanner teclado = new Scanner(System.in);
    public static Scanner tecladoString = new Scanner(System.in);


    //Metodos para validar
    /**
     * Cabecera: public static LocalDate pedirFecha()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: LocalDate con la fecha
     * Postcondiciones: Valida la fecha introducida por teclado. Si es válida devuelve true, si no lo es, false
     */

    public static LocalDate pedirFecha() {

        LocalDate fecha = null;//variable para gaurdar la fecah introducida por el usuario
        boolean fechaValida = false;//booleano para ver si la fecvha es valida

        do {//hago un do while para que al menos se haga una vez
            try {
                fecha = LocalDate.of(pedirAnho(), pedirMes(), pedirDia());//creop la fecha usando los metodos creados posteriormente para pedir los diferentes datos
                fechaValida = true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle
            } catch (DateTimeException d) {
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error

            }
        }while (!fechaValida) ;//condicion del bucle

        return fecha;
    }


    /**
     * Cabecera: public static int pedirDia()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int con el dia
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirDia(){
        int dia = 0;//variable para guardar la fecha introducida por el usuario
        boolean valido = false;//booleano para ver si la fecvha es valida

        do{//hago un do while para que al menos se haga una vez
            System.out.println("Introduzaca un dia:");
            dia = teclado.nextInt();

            try{
                DAY_OF_MONTH.checkValidValue(dia);//metodo para comprobar si el dia es valido. Si es valido, devuelve el dia, si no lo es, lanza una excepcion
                valido = true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle

            }catch(DateTimeException e){
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error

            }

        }while(!valido);//condicion del bucle

        return dia;
        }



    /**
     * Cabecera: public static int pedirMes()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int con el mes
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirMes(){

        int mes = 0;//variable para guardar la fecha introducida por el usuario
        boolean valido = false;//booleano para ver si la fecvha es valida

        do{
            System.out.println("Introduzaca un mes:");
            mes = teclado.nextInt();

            try{
                MONTH_OF_YEAR.checkValidValue(mes);//metodo para comprobar si el mes es valido. Si es valido, devuelve el mes, si no lo es, lanza una excepcion
                valido =  true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle

            }catch(DateTimeException e){
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error
            }

        }while(!valido);//condicion del bucle

        return mes;
    }

    /**
     * Cabecera: public static int pedirAnho()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int con el anho
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirAnho(){
        int anho = 0;//variable para guardar la fecha introducida por el usuario
        boolean valido = false;//booleano para ver si la fecvha es valida

        do{
            System.out.println("Introduzaca un anho:");
            anho = teclado.nextInt();

            try{
                YEAR_OF_ERA.checkValidValue(anho);//metodo para comprobar si el anho es valido. Si es valido, devuelve el anho, si no lo es, lanza una excepcion
                valido =  true;//si se ejecuta sin errores, el booleano se pone a true para salir del bucle

            }catch(DateTimeException e){
                System.out.println("Fecha no valida");//mensaje para informar al usuario del error
            }

        }while(!valido);//condicion del bucle

        return anho;
    }

    /**
     * Cabecera: public static int pedirString()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: string cadena
     * Postcondiciones: Pide una cadena al usuario
     */

    public static String pedirString(){
        String cadena = null;//variable para recoger los datos insertados por teclado y devolverlo

        while(cadena == null || cadena == " "){//mientras no sea nulo o este vacio
            cadena = tecladoString.nextLine();
        }

        return cadena;//devuelvo la variable
    }

    /**
     * Cabecera: public static Enum pedirEnum()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: Enum
     * Postcondiciones: Pide un enum al usuario
     */

    public static ParteCuerpo pedirEnum(){
        String cadena = " ";//variable para recoger los datos insertados por teclado
        ParteCuerpo enumerado = null;//variable para devolver el enumerado

        while(!cadena.equals("C") && !cadena.equals("M") && !cadena.equals("O") && !cadena.equals("c") && !cadena.equals("m") && !cadena.equals("o")){//comnpruebo que la cadena solo pueda tener los valores del enum
            System.out.println("Introduzca un enum: ");
            cadena = tecladoString.nextLine();
        }

        if (cadena.equals("C") || cadena.equals("c")){//dependiendo del valor de la cadena, le damos un valor u otro para asignarselo posteriormente al enumerado
            enumerado = ParteCuerpo.C;
        }else if(cadena.equals("M") || cadena.equals("m")){
            enumerado = ParteCuerpo.M;
        }else if(cadena.equals("O") || cadena.equals("o")){
            enumerado = ParteCuerpo.O;
        }

        return enumerado;//devuelvo el enumerado
    }

    /**
     * Cabecera: public static int pedirInt()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int
     * Postcondiciones: Pide un int al usuario
     */

    public static int pedirInt(){

        return teclado.nextInt();
    }

    /**
     * Cabecera: public static int pedirInt()
     * Precondiciones: teclado creado
     * Entradas: ninguna
     * Salida: int
     * Postcondiciones: Pide un int al usuario
     */

    public static boolean pedirOpcion(){

        int opcion = 0;//variable para recoger la opcion por teclado
        boolean salir = false;//booleano para devolver, lo inicio a false

        while(opcion != 1 && opcion != 2){//repetir mientras el usuario no ponga un 1 o un 2
            opcion = teclado.nextInt();
        }
        if (opcion == 1){//si la respuesta es 1, pongo salir a true
            salir = true;
        }

        return salir;//devuelvo el booleano salir
    }


}
