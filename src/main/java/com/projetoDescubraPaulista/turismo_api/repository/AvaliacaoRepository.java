package com.projetoDescubraPaulista.turismo_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoDescubraPaulista.turismo_api.models.Avaliacao;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    
    // Usando o nome padronizado "entidadeTipo" conforme a classe Avaliacao
    List<Avaliacao> findByEntidadeTipoAndEntidadeId(TipoEntidade entidadeTipo, Integer entidadeId);
    
    List<Avaliacao> findByUsuarioId(Integer usuarioId);
}