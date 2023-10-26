package producto2_065_BearsJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import producto2_065_BearsJava.model.Clientes;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private ClientesService clientesService;

    public Long autenticarUsuario(String username, String password) {
        // Realiza una consulta en la base de datos para verificar la contraseña
        List<Clientes> clientes = clientesService.getAllClientes();

        for (Clientes cliente : clientes) {
            if (verificarContraseña(password, cliente.getPassword())) {
                return cliente.getId(); // Autenticación exitosa
            }
        }

        return null; // Autenticación fallida
    }

    private boolean verificarContraseña(String contraseñaIngresada, String contraseñaAlmacenada) {
        return contraseñaIngresada.equals(contraseñaAlmacenada);
    }
}
