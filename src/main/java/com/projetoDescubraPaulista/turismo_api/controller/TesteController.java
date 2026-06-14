package com.projetoDescubraPaulista.turismo_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String status() {
        return "<h1>Servidor do Descubra Paulista rodando com sucesso no MySQL! 🚀</h1>";
    }
}