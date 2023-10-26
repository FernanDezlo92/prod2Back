package producto2_065_BearsJava.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "matricula")
    protected String matricula;
    @Column(name = "marca")
    protected String marca;
    @Column(name = "modelo")
    protected String modelo;

    @JoinColumn(name = "tipo_vehiculo_id")
    @ManyToOne
    protected TiposVehiculos tiposVehiculos;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    protected Clientes cliente;

    public Vehicles() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipoVehiculo(TiposVehiculos tipoVehiculo) {
        this.tiposVehiculos = tipoVehiculo;
    }

    public TiposVehiculos getTiposVehiculos() {
        return this.tiposVehiculos;
    }

}
