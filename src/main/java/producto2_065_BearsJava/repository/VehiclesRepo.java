package producto2_065_BearsJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import producto2_065_BearsJava.model.Vehicles;

public interface VehiclesRepo extends JpaRepository <Vehicles, Integer>{
    // se puede agregar métodos personalizados si es necesario
}
