package com.projetoDescubraPaulista.turismo_api.service;

import com.projetoDescubraPaulista.turismo_api.exception.ResourceNotFoundException;
import com.projetoDescubraPaulista.turismo_api.models.Roteiro;
import com.projetoDescubraPaulista.turismo_api.models.RoteiroPonto;
import com.projetoDescubraPaulista.turismo_api.repository.RoteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoteiroService {

    @Autowired
    private RoteiroRepository roteiroRepository;

    public List<Roteiro> listarTodos() {
        return roteiroRepository.findAll();
    }

    public Roteiro buscarPorId(Integer id) {
        return roteiroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Roteiro não encontrado com id: " + id));
    }

    public List<Roteiro> listarPorUsuario(Integer usuarioId) {
        return roteiroRepository.findByCriadoPorId(usuarioId);
    }

    public Roteiro salvar(Roteiro roteiro) {
        // garante que cada RoteiroPonto saiba qual é o roteiro pai
        if (roteiro.getPontos() != null) {
            for (RoteiroPonto rp : roteiro.getPontos()) {
                rp.setRoteiro(roteiro);
            }
        }
        return roteiroRepository.save(roteiro);
    }

    public Roteiro atualizar(Integer id, Roteiro dados) {
        Roteiro existente = buscarPorId(id);
        existente.setTitulo(dados.getTitulo());
        existente.setDescricao(dados.getDescricao());
        existente.setTipo(dados.getTipo());
        existente.setDuracaoHoras(dados.getDuracaoHoras());
        existente.setNivelDificuldade(dados.getNivelDificuldade());

        // substitui a lista de pontos do roteiro
        existente.getPontos().clear();
        if (dados.getPontos() != null) {
            for (RoteiroPonto novo : dados.getPontos()) {
                novo.setRoteiro(existente);
                existente.getPontos().add(novo);
            }
        }
        return roteiroRepository.save(existente);
    }

    public void deletar(Integer id) {
        Roteiro existente = buscarPorId(id);
        roteiroRepository.delete(existente);
    }
}
