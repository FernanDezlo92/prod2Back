package producto2_065_BearsJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import producto2_065_BearsJava.model.Clientes;
import producto2_065_BearsJava.service.ClientesService;
import java.util.List;

@Controller
@RequestMapping("/clientes") // Ruta base para las solicitudes relacionadas con Clientess
public class ClienteController {
    private final ClientesService clientesService;

    @Autowired
    public ClienteController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping // Mapea GET /clientes
    public String listarClientes(Model model) {
        List<Clientes> clientes = clientesService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "clientes/lista"; // Devuelve la vista "lista.html"
    }

    @GetMapping("/{id}") // Mapea GET /Clientess/{id}
    public String detalleClientes(@PathVariable Long id, Model model) {
        clientesService.getClienteById(id).ifPresent(clientes -> model.addAttribute("clientes", clientes));
        return "clientes/detalle"; // Devuelve la vista "detalle.html"
    }

    @GetMapping("/nuevo") // Mapea GET /Clientess/nuevo
    public String formularioNuevoClientes(Model model) {
        model.addAttribute("clientes", new Clientes());
        return "clientes/nuevo"; // Devuelve la vista "nuevo.html"
    }

    @PostMapping // Mapea POST /Clientess
    public String guardarClientes(@ModelAttribute Clientes clientes) {
        clientesService.guardarCliente(clientes);
        return "redirect:/clientes"; // Redirige a la lista de Clientess
    }

    @GetMapping("/{id}/editar") // Mapea GET /Clientess/{id}/editar
    public String formularioEditarClientes(@PathVariable Long id, Model model) {
        clientesService.getClienteById(id).ifPresent(clientes -> model.addAttribute("clientes", clientes));
        return "clientes/editar"; // Devuelve la vista "editar.html"
    }

    @PostMapping("/{id}") // Mapea POST /Clientess/{id}
    public String actualizarClientes(@PathVariable Long id, @ModelAttribute Clientes clientes) {
        clientesService.guardarCliente(clientes);
        return "redirect:/clientes"; // Redirige a la lista de Clientess
    }

    @GetMapping("/{id}/eliminar") // Mapea GET /Clientess/{id}/eliminar
    public String eliminarClientes(@PathVariable Long id) {
        clientesService.eliminarCliente(id);
        return "redirect:/clientes"; // Redirige a la lista de Clientess
    }
}
