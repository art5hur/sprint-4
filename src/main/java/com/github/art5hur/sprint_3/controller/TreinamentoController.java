package com.github.art5hur.sprint_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.art5hur.sprint_3.controller.dto.FormTreinamento;
import com.github.art5hur.sprint_3.lov.ListOfValueBuilder;
import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.repository.TreinamentoRepository;
import com.github.art5hur.sprint_3.service.TreinamentoService;

@Controller
@RequestMapping("treinamentos")
public class TreinamentoController {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    @Autowired
    private ListOfValueBuilder listOfValueBuilder;

    @Autowired
    private TreinamentoService treinamentoService;
    
    
    
    @GetMapping()
    public String list(Model model) {
        List<Treinamento> treinamentos = treinamentoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        model.addAttribute("treinamentos", treinamentos);
        return "treinamento/list";
    }

    @PostMapping("save")
    public String save(@ModelAttribute FormTreinamento formTreinamento) {
        Treinamento treinamento;
        
        // Se o ID já existir, busca o treinamento no banco e o atualiza.
        if (formTreinamento.getId() != null) {
            treinamento = treinamentoRepository.findById(formTreinamento.getId())
                        .orElse(new Treinamento());
            formTreinamento.updateModel(treinamento);
        } else {
            // Se não, cria um novo
            treinamento = formTreinamento.toModel();
        }
        
        treinamentoRepository.save(treinamento);
        return "redirect:/treinamentos";
    }


    @GetMapping("add")
    public String create(Model model) {
        model.addAttribute("treinamento", new FormTreinamento());
        model.addAttribute("lovAreas", listOfValueBuilder.getLovAreas());
        return "treinamento/form";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Treinamento treinamento = treinamentoRepository.findById(id).orElse(new Treinamento());
        model.addAttribute("treinamento", new FormTreinamento().toForm(treinamento));
        model.addAttribute("lovAreas", listOfValueBuilder.getLovAreas());
        return "treinamento/form";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        treinamentoRepository.deleteById(id);
        return "redirect:/treinamentos";
    }
}
