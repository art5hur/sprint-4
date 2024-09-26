package com.github.art5hur.sprint_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Aqui você pode adicionar atributos ao modelo, se necessário
        return "dashboard"; // Nome do template
    }
}
