package com.github.art5hur.sprint_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.art5hur.sprint_3.model.FormTreinamentoPendente;
import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.model.TreinamentoPendente;
import com.github.art5hur.sprint_3.repository.TreinamentoPendenteRepository;
import com.github.art5hur.sprint_3.repository.TreinamentoRepository;

@Service
public class TreinamentoPendenteService {

	@Autowired
	private TreinamentoPendenteRepository treinamentoPendenteRepository;

	@Autowired
	private TreinamentoRepository treinamentoRepository;

	public TreinamentoPendente adicionarTreinamentoPendente(FormTreinamentoPendente treinamentoPendenteDTO) {
		Treinamento treinamento = treinamentoRepository.findById(treinamentoPendenteDTO.getTreinamentoId())
				.orElseThrow(() -> new IllegalArgumentException("Treinamento não encontrado"));

		TreinamentoPendente treinamentoPendente = new TreinamentoPendente();
		treinamentoPendente.setTreinamento(treinamento);
		treinamentoPendente.setProgresso(0); // Inicia o progresso em 0%

		return treinamentoPendenteRepository.save(treinamentoPendente);
	}

	public List<TreinamentoPendente> listarTreinamentosPendentes() {
		return treinamentoPendenteRepository.findAll();
	}
}
