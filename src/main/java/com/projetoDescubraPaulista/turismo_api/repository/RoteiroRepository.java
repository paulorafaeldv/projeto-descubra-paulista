package com.projetoDescubraPaulista.turismo_api.repository;

import com.projetoDescubraPaulista.turismo_api.models.Roteiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoteiroRepository extends JpaRepository<Roteiro, Integer> {
    List<Roteiro> findByCriadoPorId(Integer usuarioId);
}
