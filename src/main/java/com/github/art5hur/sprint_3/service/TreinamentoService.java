package com.github.art5hur.sprint_3.service;

import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinamentoService {

    @Autowired
    private final TreinamentoRepository treinamentoRepository;

    public TreinamentoService(TreinamentoRepository treinamentoRepository) {
        this.treinamentoRepository = treinamentoRepository;
    }

    public void cadastrar(Treinamento treinamento) {
        treinamentoRepository.save(treinamento);
    }

    public List<Treinamento> listarTodosTreinamentos() {
        return treinamentoRepository.findAll();
    }

    public Optional<Treinamento> buscarPorId(Long id) {
        return treinamentoRepository.findById(id);
    }

    public void remover(Long id) {
        treinamentoRepository.deleteById(id);
    }
}
