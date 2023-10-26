package producto2_065_BearsJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import producto2_065_BearsJava.model.TiposVehiculos;
import producto2_065_BearsJava.model.Vehicles;
import producto2_065_BearsJava.service.VehiclesService;
import producto2_065_BearsJava.service.TiposVehiculosService;

@Controller
@RequestMapping("/vehicles") // Ruta base para las solicitudes relacionadas con Vehicles
public class VehiclesController {
    private final VehiclesService vehiclesService;

    @Autowired
    private TiposVehiculosService tipoVehiculoService;

    @Autowired
    public VehiclesController(VehiclesService vehiclesService) {
        this.vehiclesService = vehiclesService;
    }

    @GetMapping // Mapea GET /vehicles
    public String listaVehicles(Model model) {
        model.addAttribute("vehicles", vehiclesService.getAllVehicles());
        return "vehicles/lista"; // Devuelve la vista "lista.html"
    }

    @GetMapping("/{id}") // Mapea GET /vehicles/{id}
    public String detalleVehicle(@PathVariable Long id, Model model) {
        vehiclesService.getVehicleById(id).ifPresent(vehicle -> model.addAttribute("vehicle", vehicle));
        return "vehicles/detalle"; // Devuelve la vista "detalle.html"
    }

    @GetMapping("/nuevo") // Mapea GET /vehicles/nuevo
    public String formularioNuevoVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicles());
        List<TiposVehiculos> tiposVehiculos = tipoVehiculoService.getAllTiposVehiculos();
        model.addAttribute("tiposVehiculos", tiposVehiculos);
        return "vehicles/nuevo"; // Devuelve la vista "nuevo.html"
    }

    @PostMapping // Mapea POST /vehicles
    public String guardarVehicle(@ModelAttribute("vehicle") Vehicles vehicle) {
        vehiclesService.guardarVehicle(vehicle);
        return "redirect:/vehicles"; // Redirige a la lista de Vehicles
    }

    @GetMapping("/{id}/editar") // Mapea GET /vehicles/{id}/editar
    public String formularioEditarVehicle(@PathVariable Long id, Model model) {
        vehiclesService.getVehicleById(id).ifPresent(vehicle -> model.addAttribute("vehicle", vehicle));
        return "vehicles/editar"; // Devuelve la vista "editar.html"
    }

    @PostMapping("/{id}") // Mapea POST /vehicles/{id}
    public String actualizarVehicle(@PathVariable Long id, @ModelAttribute Vehicles vehicle) {
        vehiclesService.guardarVehicle(vehicle);
        return "redirect:/vehicles"; // Redirige a la lista de Vehicles
    }

    @GetMapping("/{id}/eliminar") // Mapea GET /vehicles/{id}/eliminar
    public String eliminarVehicle(@PathVariable Long id) {
        vehiclesService.eliminarVehicle(id);
        return "redirect:/vehicles"; // Redirige a la lista de Vehicles
    }
}
