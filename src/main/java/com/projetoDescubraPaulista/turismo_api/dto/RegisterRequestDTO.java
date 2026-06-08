package com.projetoDescubraPaulista.turismo_api.dto;

import com.projetoDescubraPaulista.turismo_api.models.enums.TipoUsuario;

public record RegisterRequestDTO(String nome, String email, String senha, TipoUsuario role) {
}
