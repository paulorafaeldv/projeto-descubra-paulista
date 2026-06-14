package com.projetoDescubraPaulista.turismo_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoDescubraPaulista.turismo_api.models.Avaliacao;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    List<Avaliacao> findByEntidadeTipoAndEntidadeId(TipoEntidade tipo, Integer entidadeId);
    List<Avaliacao> findByUsuarioId(Integer usuarioId);
}