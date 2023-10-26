package producto2_065_BearsJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producto2_065_BearsJava.model.TiposVehiculos;
import producto2_065_BearsJava.repository.TiposVehiculosRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TiposVehiculosService {
    private final TiposVehiculosRepo tipoVehiculoRepository;

    @Autowired
    public TiposVehiculosService(TiposVehiculosRepo tipoVehiculoRepository) {
        this.tipoVehiculoRepository = tipoVehiculoRepository;
    }

    public List<TiposVehiculos> getAllTiposVehiculos() {
        return tipoVehiculoRepository.findAll();
    }

    public Optional<TiposVehiculos> getTipoVehiculoById(Long id) {
        return tipoVehiculoRepository.findById(id);
    }

    public void guardarTipoVehiculo(TiposVehiculos tiposVehiculos) {
        tipoVehiculoRepository.save(tiposVehiculos);
    }

    public void eliminarTipoVehiculo(Long id) {
        tipoVehiculoRepository.deleteById(id);
    }
}
