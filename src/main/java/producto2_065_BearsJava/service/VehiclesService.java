package producto2_065_BearsJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producto2_065_BearsJava.model.Vehicles;
import producto2_065_BearsJava.repository.VehiclesRepo;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclesService {
    private final VehiclesRepo vehiclesRepo;

    @Autowired
    public VehiclesService(VehiclesRepo vehiclesRepo) {
        this.vehiclesRepo = vehiclesRepo;
    }

    public List<Vehicles> getAllVehicles() {
        return vehiclesRepo.findAll();
    }

    public Optional<Vehicles> getVehicleById(Long id) {
        return vehiclesRepo.findById(id);
    }

    public void guardarVehicle(Vehicles vehicle) {

        vehiclesRepo.save(vehicle);
    }

    public void eliminarVehicle(Long id) {
        vehiclesRepo.deleteById(id);
    }
}
