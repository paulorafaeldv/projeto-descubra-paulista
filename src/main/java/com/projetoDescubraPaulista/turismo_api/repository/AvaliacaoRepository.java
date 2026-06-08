package com.projetoDescubraPaulista.turismo_api.repository;

import com.projetoDescubraPaulista.turismo_api.models.Avaliacao;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    List<Avaliacao> findByTipoEntidadeAndEntidadeId(TipoEntidade tipoEntidade, Integer entidadeId);
}