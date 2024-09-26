// src/main/java/com/github/acnaweb/mvc_rh/controller/LoginController.java

package com.github.art5hur.sprint_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, 
                        @RequestParam(value = "logout", required = false) String logout, 
                        Model model) {
        if (error != null) {
            model.addAttribute("errorMessage", "Login ou senha inválidos. Por favor, tente novamente.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "Você saiu com sucesso.");
        }
        return "login";
    }
}
