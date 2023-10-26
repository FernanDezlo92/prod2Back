package producto2_065_BearsJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import producto2_065_BearsJava.model.Coche;
import producto2_065_BearsJava.service.CocheService;

@Controller
@RequestMapping("/coches") // Ruta base para las solicitudes relacionadas con Coches
public class CocheController {
    private final CocheService cocheService;

    @Autowired
    public CocheController(CocheService cocheService) {
        this.cocheService = cocheService;
    }

    @GetMapping // Mapea GET /coches
    public String listaCoches(Model model) {
        model.addAttribute("coches", cocheService.getAllCoches());
        return "coches/lista"; // Devuelve la vista "lista.html"
    }

    @GetMapping("/{id}") // Mapea GET /coches/{id}
    public String detalleCoche(@PathVariable Long id, Model model) {
        cocheService.getCocheById(id).ifPresent(coche -> model.addAttribute("coche", coche));
        return "coches/detalle"; // Devuelve la vista "detalle.html"
    }

    @GetMapping("/nuevo") // Mapea GET /coches/nuevo
    public String formularioNuevoCoche(Model model) {
        model.addAttribute("coche", new Coche());
        return "coches/nuevo"; // Devuelve la vista "nuevo.html"
    }

    @PostMapping // Mapea POST /coches
    public String guardarCoche(@ModelAttribute Coche coche) {
        cocheService.guardarCoche(coche);
        return "redirect:/coches"; // Redirige a la lista de coches
    }

    @GetMapping("/{id}/editar") // Mapea GET /coches/{id}/editar
    public String formularioEditarCoche(@PathVariable Long id, Model model) {
        cocheService.getCocheById(id).ifPresent(coche -> model.addAttribute("coche", coche));
        return "coches/editar"; // Devuelve la vista "editar.html"
    }

    @PostMapping("/{id}") // Mapea POST /coches/{id}
    public String actualizarCoche(@PathVariable Long id, @ModelAttribute Coche coche) {
        cocheService.guardarCoche(coche);
        return "redirect:/coches"; // Redirige a la lista de coches
    }

    @GetMapping("/{id}/eliminar") // Mapea GET /coches/{id}/eliminar
    public String eliminarCoche(@PathVariable Long id) {
        cocheService.eliminarCoche(id);
        return "redirect:/coches"; // Redirige a la lista de coches
    }
}
