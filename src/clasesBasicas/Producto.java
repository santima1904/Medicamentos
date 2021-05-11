package clasesBasicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public abstract class Producto implements Serializable {


    //Atributos
    private String codigoBarras;
    private String nombre;
    private LocalDate fechaCaducidad;
    private double precio;

    //Constructor sin parametros

    public Producto() {
        codigoBarras = null;
        nombre = " ";
        fechaCaducidad = null;
        precio = 0;
    }

    //Constructor con parametros

    public Producto(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio) {
        this.codigoBarras = " ";
        this.nombre = nombre;
        this.fechaCaducidad = fechaCaducidad;
        this.precio = precio;
    }


    //Getters and setters

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    //Metodos de la clase Object

    //toString
    @Override
    public String toString() {
        return "Producto " +'\''+
                "codigoBarras='" + codigoBarras + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaCaducidad=" + fechaCaducidad +
                ", precio=" + precio
                ;
    }

   //compareTo
    /*
    Criterios de igualdad:
     0 si son iguales
     1 si el objeto dado es mayor
    -1 si es menor
     */
    public int compareTo(Producto o) {

        return this.codigoBarras.compareTo(o.getCodigoBarras());
    }


    //equals
    public boolean equals(Producto o) {
        boolean igual = false;
        if (this == o){
            igual = true;
        }
        if (!(o instanceof Producto)){
            if (this.codigoBarras == o.getCodigoBarras()){
                igual = true;
            }
        }
        return igual;
    }

}
