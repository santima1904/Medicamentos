package clasesBasicas;

import enums.Presentacion;

import java.time.LocalDate;

public class Medicamento extends Producto{

    //Atributos
    private Presentacion presentacion;
    private String principioActivo;

    //Constructor por defecto

    public Medicamento() {
        this.presentacion = null;
        this.principioActivo = null;
    }

    //Constructor con parametros
    public Medicamento(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio, Presentacion presentacion, String principioActivo) {
        super(codigoBarras, nombre, fechaCaducidad, precio);
        this.presentacion = presentacion;
        this.principioActivo = principioActivo;
    }

    //Getters and setters

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    //toString

    @Override
    public String toString() {
        return super.toString() +
                "presentacion=" + presentacion +
                ", principioActivo='" + principioActivo + '\'' +
                '}';
    }
}
