package producto2_065_BearsJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producto2_065_BearsJava.model.Coche;
import producto2_065_BearsJava.repository.CocheRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CocheService {
    private final CocheRepo cocheRepo;

    @Autowired
    public CocheService(CocheRepo cocheRepo) {
        this.cocheRepo = cocheRepo;
    }

    public List<Coche> getAllCoches() {
        return cocheRepo.findAll();
    }

    public Optional<Coche> getCocheById(Long id) {
        return cocheRepo.findById(id);
    }

    public void guardarCoche(Coche coche) {
        cocheRepo.save(coche);
    }

    public void eliminarCoche(Long id) {
        cocheRepo.deleteById(id);
    }
}
