package com.github.art5hur.sprint_3.controller;

import com.github.art5hur.sprint_3.controller.dto.FormTreinamento;
import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.repository.TreinamentoRepository;
import com.github.art5hur.sprint_3.lov.ListOfValueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("treinamentos")
public class TreinamentoController {

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    @Autowired
    private ListOfValueBuilder listOfValueBuilder;

    @GetMapping()
    public String list(Model model) {
        List<Treinamento> treinamentos = treinamentoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
        model.addAttribute("treinamentos", treinamentos);
        return "treinamento/list";
    }

    @PostMapping("save")
    public String save(@ModelAttribute FormTreinamento formTreinamento) {
        Treinamento treinamento = formTreinamento.toModel();
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
