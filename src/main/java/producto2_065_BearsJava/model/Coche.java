package producto2_065_BearsJava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")
public class Coche extends Vehicles {
    @Column(name = "puertas")
    private int puertas;

    @Column(name = "plazas")
    private int plazas;

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public Coche() {
    }

}
