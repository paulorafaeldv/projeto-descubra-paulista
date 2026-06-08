package com.projetoDescubraPaulista.turismo_api.service;

import com.projetoDescubraPaulista.turismo_api.exception.ResourceNotFoundException;
import com.projetoDescubraPaulista.turismo_api.models.Avaliacao;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;
import com.projetoDescubraPaulista.turismo_api.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> listarTodas() {
        return avaliacaoRepository.findAll();
    }

    public List<Avaliacao> listarPorEntidade(TipoEntidade tipo, Integer entidadeId) {
        return avaliacaoRepository.findByTipoEntidadeAndEntidadeId(tipo, entidadeId);
    }

    public Avaliacao buscarPorId(Integer id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliação não encontrada com id: " + id));
    }

    public Avaliacao salvar(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public void deletar(Integer id) {
        Avaliacao existente = buscarPorId(id);
        avaliacaoRepository.delete(existente);
    }
}