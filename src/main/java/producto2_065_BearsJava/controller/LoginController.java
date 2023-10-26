package producto2_065_BearsJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import producto2_065_BearsJava.service.AuthService;

@Controller
public class LoginController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String mostrarPaginaInicioSesion() {
        return "Login/login";
    }

    @GetMapping("/clientelogin")
    public String mostrarPaginaInicioSesionCliente() {
        return "Login/clientelogin";
    }

    @PostMapping("/loginform")
    public String procesarInicioSesion(@RequestParam("username") String username,
            @RequestParam("password") String password, HttpSession session) {
        Long clienteId = authService.autenticarUsuario(username, password);

        if (clienteId != null) {
            session.setAttribute("clienteId", clienteId); // Almacenar el ID del cliente en la sesión
            return "redirect:/clientelogin?id=" + clienteId; // Redirigir a la página de cliente con su ID
        } else {
            return "redirect:/login-error";
        }
    }

}
