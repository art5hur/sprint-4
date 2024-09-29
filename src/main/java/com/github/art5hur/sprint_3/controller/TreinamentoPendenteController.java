package com.github.art5hur.sprint_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.art5hur.sprint_3.model.FormTreinamentoPendente;
import com.github.art5hur.sprint_3.model.TreinamentoPendente;
import com.github.art5hur.sprint_3.service.TreinamentoPendenteService;

@Controller
public class TreinamentoPendenteController {

	@Autowired
	private TreinamentoPendenteService treinamentoPendenteService;
    
	@Secured({"ROLE_USER", "ROLE_RH"})
	@GetMapping("/treinamentos-pendentes")
	public String listarTreinamentosPendentes(Model model) {
		List<TreinamentoPendente> treinamentosPendentes = treinamentoPendenteService.listarTreinamentosPendentes();
		model.addAttribute("treinamentosPendentes", treinamentosPendentes);
		return "treinamentos/pendentes"; // Página para treinamentos pendentes
	}

	@PostMapping("/treinamentos-pendentes")
    public String adicionarTreinamentoPendente(@RequestParam("treinamentoId") Long treinamentoId, RedirectAttributes redirectAttributes) {
        // Cria um objeto FormTreinamentoPendente e define o treinamentoId
        FormTreinamentoPendente formTreinamentoPendente = new FormTreinamentoPendente();
        formTreinamentoPendente.setTreinamentoId(treinamentoId);

        // Chama o método do serviço com o objeto correto
        treinamentoPendenteService.adicionarTreinamentoPendente(formTreinamentoPendente);

        // Redireciona de volta para a página de listagem de treinamentos pendentes
        redirectAttributes.addFlashAttribute("mensagem", "Treinamento adicionado com sucesso!");
        return "redirect:/treinamentos-pendentes";
    }
}
