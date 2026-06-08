package com.projetoDescubraPaulista.turismo_api.service;

import com.projetoDescubraPaulista.turismo_api.exception.ResourceNotFoundException;
import com.projetoDescubraPaulista.turismo_api.models.Favorito;
import com.projetoDescubraPaulista.turismo_api.repository.FavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    public List<Favorito> listarPorUsuario(Integer usuarioId) {
        return favoritoRepository.findByUsuarioId(usuarioId);
    }

    public Favorito salvar(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    public void deletar(Integer id) {
        Favorito existente = favoritoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Favorito não encontrado com id: " + id));
        favoritoRepository.delete(existente);
    }
}