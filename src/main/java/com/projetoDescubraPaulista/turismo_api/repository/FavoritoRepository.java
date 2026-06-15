package com.projetoDescubraPaulista.turismo_api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoDescubraPaulista.turismo_api.models.Favorito;
import com.projetoDescubraPaulista.turismo_api.models.enums.TipoEntidade;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
    
    List<Favorito> findByUsuarioId(Integer usuarioId);
    
    Optional<Favorito> findByUsuarioIdAndEntidadeTipoAndEntidadeId(
            Integer usuarioId, TipoEntidade entidadeTipo, Integer entidadeId);
}