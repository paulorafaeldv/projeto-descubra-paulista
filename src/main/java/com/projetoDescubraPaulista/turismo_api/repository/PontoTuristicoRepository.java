package com.projetoDescubraPaulista.turismo_api.repository;

import com.projetoDescubraPaulista.turismo_api.models.PontoTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico, Integer> {
    List<PontoTuristico> findByAtivoTrue();
    List<PontoTuristico> findByCategoriaId(Integer categoriaId);
}
