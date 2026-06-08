package com.projetoDescubraPaulista.turismo_api.repository;

import com.projetoDescubraPaulista.turismo_api.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    List<Evento> findByDataInicioGreaterThanEqualOrderByDataInicioAsc(LocalDate data);
    List<Evento> findByGratuitoTrue();
}
