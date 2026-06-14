package com.projetoDescubraPaulista.turismo_api.dto;

import com.projetoDescubraPaulista.turismo_api.models.enums.TipoUsuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nome,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,
    
    @NotBlank(message = "Senha é obrigatória")
    String senha,
    
    TipoUsuario tipo
) {}