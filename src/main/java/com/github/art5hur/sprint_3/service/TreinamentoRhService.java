package com.github.art5hur.sprint_3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.art5hur.sprint_3.model.TreinamentoRh;
import com.github.art5hur.sprint_3.repository.TreinamentoRhRepository;

@Service
public class TreinamentoRhService {

    @Autowired
    private final TreinamentoRhRepository treinamentoRhRepository;

    public TreinamentoRhService(TreinamentoRhRepository treinamentoRhRepository) {
        this.treinamentoRhRepository = treinamentoRhRepository;
    }

    public void cadastrar(TreinamentoRh treinamentoRh) {
        treinamentoRhRepository.save(treinamentoRh);
    }

    public List<TreinamentoRh> listarTodos() {
        return treinamentoRhRepository.findAll();
    }

    public Optional<TreinamentoRh> buscarPorId(Long id) {
        return treinamentoRhRepository.findById(id);
    }

    public void remover(Long id) {
        treinamentoRhRepository.deleteById(id);
    }
}
