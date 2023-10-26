package producto2_065_BearsJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import producto2_065_BearsJava.model.TiposVehiculos;
import producto2_065_BearsJava.service.TiposVehiculosService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tiposvehiculos")
public class TipoVehiculoController {
    private final TiposVehiculosService tiposVehiculosService;

    @Autowired
    public TipoVehiculoController(TiposVehiculosService tiposVehiculosService) {
        this.tiposVehiculosService = tiposVehiculosService;
    }

    @GetMapping // Mapea GET /tiposvehiculos
    public String listaTiposvehiculo(Model model) {
        List<TiposVehiculos> tiposVehiculos = tiposVehiculosService.getAllTiposVehiculos();
        model.addAttribute("tipoVehiculo", tiposVehiculos);
        return "tiposvehiculos/lista";
    }

    @GetMapping("/{id}") // Mapea GET /tiposvehiculos/{id}
    public String detalleTipoVehiculo(@PathVariable Long id, Model model) {
        Optional<TiposVehiculos> tipoVehiculo = tiposVehiculosService.getTipoVehiculoById(id);
        tipoVehiculo.ifPresent(value -> model.addAttribute("tipoVehiculo", value));
        return "tiposvehiculos/detalle";
    }

    @GetMapping("/nuevo") // Mapea GET /tiposvehiculos/nuevo
    public String formularioNuevoTipoVehiculo(Model model) {
        model.addAttribute("tipoVehiculo", new TiposVehiculos());
        return "tiposvehiculos/nuevo";
    }

    @PostMapping // Mapea POST /tiposvehiculos
    public String guardarTipoVehiculo(@ModelAttribute TiposVehiculos tipoVehiculo) {
        tiposVehiculosService.guardarTipoVehiculo(tipoVehiculo);
        return "redirect:/tiposvehiculos"; // Redirige a la lista de TiposVehiculos
    }

    @GetMapping("/{id}/editar") // Mapea GET /tiposvehiculos/{id}/editar
    public String formularioEditarTipoVehiculo(@PathVariable Long id, Model model) {
        Optional<TiposVehiculos> tipoVehiculo = tiposVehiculosService.getTipoVehiculoById(id);
        tipoVehiculo.ifPresent(value -> model.addAttribute("tipoVehiculo", value));
        return "tiposvehiculos/editar";
    }

    @PostMapping("/{id}") // Mapea POST /tiposvehiculos/{id}
    public String actualizarTipoVehiculo(@PathVariable Long id, @ModelAttribute TiposVehiculos tipoVehiculo) {
        tiposVehiculosService.guardarTipoVehiculo(tipoVehiculo);
        return "redirect:/tiposvehiculos"; // Redirige a la lista de TiposVehiculos
    }

    @GetMapping("/{id}/eliminar") // Mapea GET /tiposvehiculos/{id}/eliminar
    public String eliminarTipoVehiculo(@PathVariable Long id) {
        tiposVehiculosService.eliminarTipoVehiculo(id);
        return "redirect:/tiposvehiculos"; // Redirige a la lista de TiposVehiculos
    }
}
