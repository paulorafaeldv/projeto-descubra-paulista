package com.projetoDescubraPaulista.turismo_api.service;

import com.projetoDescubraPaulista.turismo_api.exception.ResourceNotFoundException;
import com.projetoDescubraPaulista.turismo_api.models.Categoria;
import com.projetoDescubraPaulista.turismo_api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada com id: " + id));
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Integer id, Categoria dados) {
        Categoria existente = buscarPorId(id);
        existente.setNome(dados.getNome());
        existente.setIcone(dados.getIcone());
        existente.setCor(dados.getCor());
        return categoriaRepository.save(existente);
    }

    public void deletar(Integer id) {
        Categoria existente = buscarPorId(id);
        categoriaRepository.delete(existente);
    }
}
