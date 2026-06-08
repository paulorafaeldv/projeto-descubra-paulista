package com.descubrapaulista.controller;

import com.descubrapaulista.model.Avaliacao;
import com.descubrapaulista.model.enums.TipoEntidade;
import com.descubrapaulista.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> listar(
            @RequestParam(required = false) TipoEntidade tipo,
            @RequestParam(required = false) Integer entidadeId) {
        if (tipo != null && entidadeId != null) {
            return avaliacaoService.listarPorEntidade(tipo, entidadeId);
        }
        return avaliacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Avaliacao buscar(@PathVariable Integer id) {
        return avaliacaoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Avaliacao> cadastrar(@Valid @RequestBody Avaliacao avaliacao) {
        return ResponseEntity.status(201).body(avaliacaoService.salvar(avaliacao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
