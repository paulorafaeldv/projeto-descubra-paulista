package com.projetoDescubraPaulista.turismo_api.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoDescubraPaulista.turismo_api.models.Avaliacao;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;
import com.projetoDescubraPaulista.turismo_api.service.AvaliacaoService;

import jakarta.validation.Valid;
=======
import com.projetoDescubraPaulista.turismo_api.models.Avaliacao;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;
import com.projetoDescubraPaulista.turismo_api.service.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> aa5abf510fdf5a066aa05aca82df8623807fdbc6

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
<<<<<<< HEAD
}
=======
}
>>>>>>> aa5abf510fdf5a066aa05aca82df8623807fdbc6
