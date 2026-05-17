package com.descubrapaulista.service;

import com.descubrapaulista.exception.ResourceNotFoundException;
import com.descubrapaulista.model.Usuario;
import com.descubrapaulista.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com id: " + id));
    }

    public Usuario cadastrar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalArgumentException("Já existe um usuário com este email");
        }
        // OBSERVAÇÃO DIDÁTICA: em produção, use BCrypt para hashear a senha.
        // Aqui guardamos como veio para simplificar o exemplo acadêmico.
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Integer id, Usuario dados) {
        Usuario existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setTelefone(dados.getTelefone());
        existente.setTipo(dados.getTipo());
        return usuarioRepository.save(existente);
    }

    public void deletar(Integer id) {
        Usuario existente = buscarPorId(id);
        usuarioRepository.delete(existente);
    }
}
