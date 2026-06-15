package com.projetoDescubraPaulista.turismo_api.controller;
<<<<<<< HEAD

=======
>>>>>>> aa5abf510fdf5a066aa05aca82df8623807fdbc6
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public String status() {
        return "<h1>Servidor do Descubra Paulista rodando com sucesso no MySQL! 🚀</h1>";
    }
}