package com.projetoDescubraPaulista.turismo_api.controller;

import com.projetoDescubraPaulista.turismo_api.models.Favorito;
import com.projetoDescubraPaulista.turismo_api.service.FavoritoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
@CrossOrigin(origins = "*")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> listarPorUsuario(@PathVariable Integer usuarioId) {
        return favoritoService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public ResponseEntity<Favorito> salvar(@Valid @RequestBody Favorito favorito) {
        return ResponseEntity.status(201).body(favoritoService.salvar(favorito));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        favoritoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
