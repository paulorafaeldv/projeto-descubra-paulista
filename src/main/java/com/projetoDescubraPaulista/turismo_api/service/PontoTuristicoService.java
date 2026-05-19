package com.descubrapaulista.service;

import com.descubrapaulista.exception.ResourceNotFoundException;
import com.descubrapaulista.model.PontoTuristico;
import com.descubrapaulista.repository.PontoTuristicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PontoTuristicoService {

    @Autowired
    private PontoTuristicoRepository pontoTuristicoRepository;

    public List<PontoTuristico> listarTodos() {
        return pontoTuristicoRepository.findAll();
    }

    public List<PontoTuristico> listarAtivos() {
        return pontoTuristicoRepository.findByAtivoTrue();
    }

    public List<PontoTuristico> listarPorCategoria(Integer categoriaId) {
        return pontoTuristicoRepository.findByCategoriaId(categoriaId);
    }

    public PontoTuristico buscarPorId(Integer id) {
        return pontoTuristicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ponto turístico não encontrado com id: " + id));
    }

    public PontoTuristico salvar(PontoTuristico ponto) {
        if (ponto.getAtivo() == null) ponto.setAtivo(true);
        return pontoTuristicoRepository.save(ponto);
    }

    public PontoTuristico atualizar(Integer id, PontoTuristico dados) {
        PontoTuristico existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setDescricao(dados.getDescricao());
        existente.setCategoria(dados.getCategoria());
        existente.setLatitude(dados.getLatitude());
        existente.setLongitude(dados.getLongitude());
        existente.setEndereco(dados.getEndereco());
        existente.setFotoUrl(dados.getFotoUrl());
        if (dados.getAtivo() != null) existente.setAtivo(dados.getAtivo());
        return pontoTuristicoRepository.save(existente);
    }

    public void deletar(Integer id) {
        PontoTuristico existente = buscarPorId(id);
        // soft delete: marca como inativo (preserva histórico em roteiros e avaliações)
        existente.setAtivo(false);
        pontoTuristicoRepository.save(existente);
    }
}
