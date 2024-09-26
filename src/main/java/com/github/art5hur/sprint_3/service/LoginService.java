package com.github.art5hur.sprint_3.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateLogin(String email, String password) {
        // Valide o login aqui, possivelmente com uma consulta ao banco de dados
        return "joaosantos@eurofarma.com.br".equals(email) && "password".equals(password);
    }
}
