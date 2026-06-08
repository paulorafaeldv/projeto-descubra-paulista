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

import com.projetoDescubraPaulista.turismo_api.models.PontoTuristico;
import com.projetoDescubraPaulista.turismo_api.service.PontoTuristicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pontos-turisticos")
@CrossOrigin(origins = "*")
public class PontoTuristicoController {

    @Autowired
    private PontoTuristicoService pontoTuristicoService;

    /**
     * Lista todos os pontos turísticos ativos da cidade.
     * Aceita ?categoriaId=X para filtrar por categoria.
     */
    @GetMapping
    public List<PontoTuristico> listar(@RequestParam(required = false) Integer categoriaId) {
        if (categoriaId != null) {
            return pontoTuristicoService.listarPorCategoria(categoriaId);
        }
        return pontoTuristicoService.listarAtivos();
    }

    @GetMapping("/{id}")
    public PontoTuristico buscar(@PathVariable Integer id) {
        return pontoTuristicoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<PontoTuristico> cadastrar(@Valid @RequestBody PontoTuristico ponto) {
        return ResponseEntity.status(201).body(pontoTuristicoService.salvar(ponto));
    }

    @PutMapping("/{id}")
    public PontoTuristico atualizar(@PathVariable Integer id, @Valid @RequestBody PontoTuristico dados) {
        return pontoTuristicoService.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        pontoTuristicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
