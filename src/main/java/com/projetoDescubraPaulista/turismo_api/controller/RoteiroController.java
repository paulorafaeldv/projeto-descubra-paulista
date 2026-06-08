package com.projetoDescubraPaulista.turismo_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoDescubraPaulista.turismo_api.models.Roteiro;
import com.projetoDescubraPaulista.turismo_api.service.RoteiroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/roteiros")
@CrossOrigin(origins = "*")
public class RoteiroController {

    @Autowired
    private RoteiroService roteiroService;

    @GetMapping
    public List<Roteiro> listar(@RequestParam(required = false) Integer usuarioId) {
        if (usuarioId != null) {
            return roteiroService.listarPorUsuario(usuarioId);
        }
        return roteiroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Roteiro buscar(@PathVariable Integer id) {
        return roteiroService.buscarPorId(id);
    }

    /**
     * Cria um novo roteiro personalizado.
     * Pode receber a lista de pontos no mesmo POST.
     */
    @PostMapping
    public ResponseEntity<Roteiro> cadastrar(@Valid @RequestBody Roteiro roteiro) {
        return ResponseEntity.status(201).body(roteiroService.salvar(roteiro));
    }

    @PutMapping("/{id}")
    public Roteiro atualizar(@PathVariable Integer id, @Valid @RequestBody Roteiro dados) {
        return roteiroService.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        roteiroService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
