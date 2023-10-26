package producto2_065_BearsJava.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipos_vehiculos")
public class TiposVehiculos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tiposVehiculos")
    private List<Vehicles> vehicles;

    // Constructor, getters y setters

    public TiposVehiculos() {
        // Constructor vacío
    }

    public TiposVehiculos(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }
}
