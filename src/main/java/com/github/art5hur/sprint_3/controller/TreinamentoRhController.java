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

import com.github.art5hur.sprint_3.controller.dto.FormTreinamentoRh;
import com.github.art5hur.sprint_3.lov.ListOfValueBuilder;
import com.github.art5hur.sprint_3.model.TreinamentoRh;
import com.github.art5hur.sprint_3.repository.TreinamentoRhRepository;

@Controller
@RequestMapping("treinamentosRh")
public class TreinamentoRhController {

    @Autowired
    private TreinamentoRhRepository treinamentoRhRepository;

    @Autowired
    private ListOfValueBuilder listOfValueBuilder;

    @GetMapping()
    public String list(Model model) {
        List<TreinamentoRh> treinamentosRh = treinamentoRhRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        model.addAttribute("treinamentosRh", treinamentosRh);
        return "treinamentoRh/list";
    }

    @PostMapping("save")
    public String save(@ModelAttribute FormTreinamentoRh formTreinamentoRh) {
        TreinamentoRh treinamentoRh;
        
        // Se o ID já existir, busca o treinamento no banco e o atualiza.
        if (formTreinamentoRh.getId() != null) {
            treinamentoRh = treinamentoRhRepository.findById(formTreinamentoRh.getId())
                        .orElse(new TreinamentoRh());
            formTreinamentoRh.updateModel(treinamentoRh);
        } else {
            // Se não, cria um novo
            treinamentoRh = formTreinamentoRh.toModel();
        }
        
        treinamentoRhRepository.save(treinamentoRh);
        return "redirect:/treinamentosRh";
    }


    @GetMapping("add")
    public String create(Model model) {
        model.addAttribute("treinamentoRh", new FormTreinamentoRh());
        model.addAttribute("lovAreas", listOfValueBuilder.getLovAreas());
        return "treinamentoRh/form";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, Model model) {
        TreinamentoRh treinamentoRh = treinamentoRhRepository.findById(id).orElse(new TreinamentoRh());
        model.addAttribute("treinamentoRh", new FormTreinamentoRh().toForm(treinamentoRh));
        model.addAttribute("lovAreas", listOfValueBuilder.getLovAreas());
        return "treinamentoRh/form";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        treinamentoRhRepository.deleteById(id);
        return "redirect:/treinamentosRh";
    }
}
