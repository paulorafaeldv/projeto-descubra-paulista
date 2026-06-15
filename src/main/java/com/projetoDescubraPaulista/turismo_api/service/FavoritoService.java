package com.projetoDescubraPaulista.turismo_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoDescubraPaulista.turismo_api.exception.ResourceNotFoundException;
import com.projetoDescubraPaulista.turismo_api.models.Favorito;
import com.projetoDescubraPaulista.turismo_api.repository.FavoritoRepository;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> listarPorUsuario(Integer usuarioId) {
        return favoritoRepository.findByUsuarioId(usuarioId);
    }

    public Favorito salvar(Favorito favorito) {
        // Verifica se já existe um favorito com esses dados para evitar duplicidade
        return favoritoRepository
                .findByUsuarioIdAndEntidadeTipoAndEntidadeId(
                        favorito.getUsuario().getId(),
                        favorito.getEntidadeTipo(),
                        favorito.getEntidadeId())
                .orElseGet(() -> favoritoRepository.save(favorito));
    }

    public void deletar(Integer id) {
        Favorito existente = favoritoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Favorito não encontrado com id: " + id));
        favoritoRepository.delete(existente);
    }
}