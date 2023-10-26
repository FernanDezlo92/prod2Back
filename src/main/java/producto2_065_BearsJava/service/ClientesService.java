package producto2_065_BearsJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producto2_065_BearsJava.model.Clientes;
import producto2_065_BearsJava.repository.ClientesRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    private final ClientesRepo clientesRepo;

    @Autowired
    public ClientesService(ClientesRepo clientesRepo) {
        this.clientesRepo = clientesRepo;
    }

    public List<Clientes> getAllClientes() {
        return clientesRepo.findAll();
    }

    public Optional<Clientes> getClienteById(Long id) {
        return clientesRepo.findById(id);
    }

    public void guardarCliente(Clientes cliente) {
        clientesRepo.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clientesRepo.deleteById(id);
    }
}
