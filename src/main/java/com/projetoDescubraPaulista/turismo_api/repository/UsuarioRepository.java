package com.projetoDescubraPaulista.turismo_api.repository;

import com.projetoDescubraPaulista.turismo_api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);
}
