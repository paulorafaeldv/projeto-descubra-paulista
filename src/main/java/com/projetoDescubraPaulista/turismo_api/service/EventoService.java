package com.descubrapaulista.service;

import com.descubrapaulista.exception.ResourceNotFoundException;
import com.descubrapaulista.model.Evento;
import com.descubrapaulista.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    /**
     * Agenda da cidade: somente eventos a partir de hoje, em ordem cronológica.
     */
    public List<Evento> listarAgenda() {
        return eventoRepository.findByDataInicioGreaterThanEqualOrderByDataInicioAsc(LocalDate.now());
    }

    public List<Evento> listarGratuitos() {
        return eventoRepository.findByGratuitoTrue();
    }

    public Evento buscarPorId(Integer id) {
        return eventoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com id: " + id));
    }

    public Evento salvar(Evento evento) {
        if (evento.getDataFim() != null && evento.getDataInicio() != null
                && evento.getDataFim().isBefore(evento.getDataInicio())) {
            throw new IllegalArgumentException("Data fim não pode ser anterior à data início");
        }
        return eventoRepository.save(evento);
    }

    public Evento atualizar(Integer id, Evento dados) {
        Evento existente = buscarPorId(id);
        existente.setTitulo(dados.getTitulo());
        existente.setDescricao(dados.getDescricao());
        existente.setCategoria(dados.getCategoria());
        existente.setDataInicio(dados.getDataInicio());
        existente.setDataFim(dados.getDataFim());
        existente.setLocal(dados.getLocal());
        existente.setLatitude(dados.getLatitude());
        existente.setLongitude(dados.getLongitude());
        existente.setFotoUrl(dados.getFotoUrl());
        existente.setGratuito(dados.getGratuito());
        existente.setOrganizador(dados.getOrganizador());
        return eventoRepository.save(existente);
    }

    public void deletar(Integer id) {
        Evento existente = buscarPorId(id);
        eventoRepository.delete(existente);
    }
}
