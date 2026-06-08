package com.projetoDescubraPaulista.turismo_api.service;

import com.projetoDescubraPaulista.turismo_api.dto.RegisterRequestDTO;
import com.projetoDescubraPaulista.turismo_api.models.Usuario;
import com.projetoDescubraPaulista.turismo_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + username));
    }

    public Usuario registrar(RegisterRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já cadastrado");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setSenhaHash(passwordEncoder.encode(dto.senha()));
        novoUsuario.setTipo(dto.role());

        return usuarioRepository.save(novoUsuario);
    }
}
