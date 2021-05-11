package clasesBasicas;

import enums.ParteCuerpo;

import java.time.LocalDate;

public class Epi extends Producto{

    //Atributos
    private ParteCuerpo parteCuerpo;
    private String material;


    //Constructor por defecto

    public Epi() {
        this.parteCuerpo = null;
        this.material = null;
    }

    //Constructor con parametros
    public Epi(String codigoBarras, String nombre, LocalDate fechaCaducidad, double precio, ParteCuerpo parteCuerpo, String material) {
        super(codigoBarras, nombre, fechaCaducidad, precio);
        this.parteCuerpo = parteCuerpo;
        this.material = material;
    }

    //Getters and setters

    public ParteCuerpo getparteCuerpo() {
        return parteCuerpo;
    }

    public void setParteCuerpo(ParteCuerpo parteCuerpo) {
        this.parteCuerpo = parteCuerpo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    //toString

    @Override
    public String toString() {
        return super.toString() +
                "parteCuerpo=" + parteCuerpo +
                ", material='" + material + '\'' ;
    }
}