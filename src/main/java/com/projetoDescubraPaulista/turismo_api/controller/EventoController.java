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

import com.projetoDescubraPaulista.turismo_api.models.Evento;
import com.projetoDescubraPaulista.turismo_api.service.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    /**
     * Retorna a agenda de eventos da cidade (a partir de hoje).
     * Use ?gratuito=true para listar apenas os eventos gratuitos.
     */
    @GetMapping
    public List<Evento> listar(@RequestParam(required = false) Boolean gratuito) {
        if (Boolean.TRUE.equals(gratuito)) {
            return eventoService.listarGratuitos();
        }
        return eventoService.listarAgenda();
    }

    @GetMapping("/todos")
    public List<Evento> listarTodos() {
        return eventoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Evento buscar(@PathVariable Integer id) {
        return eventoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Evento> cadastrar(@Valid @RequestBody Evento evento) {
        return ResponseEntity.status(201).body(eventoService.salvar(evento));
    }

    @PutMapping("/{id}")
    public Evento atualizar(@PathVariable Integer id, @Valid @RequestBody Evento dados) {
        return eventoService.atualizar(id, dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        eventoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
