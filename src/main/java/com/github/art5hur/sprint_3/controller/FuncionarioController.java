package com.github.art5hur.sprint_3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.art5hur.sprint_3.controller.dto.FormFuncionario;
import com.github.art5hur.sprint_3.lov.ListOfValueBuilder;
import com.github.art5hur.sprint_3.model.Cargo;
import com.github.art5hur.sprint_3.model.Funcionario;
import com.github.art5hur.sprint_3.repository.CargoRepository;
import com.github.art5hur.sprint_3.repository.FuncionarioRepository;

@Controller
@RequestMapping("funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private ListOfValueBuilder listOfValueBuilder;

	@GetMapping()
	public String list(Model model) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/list";
	}

	@PostMapping("save")
	public String save(@ModelAttribute FormFuncionario funcionario) {
		Cargo cargo = Optional.ofNullable(funcionario.getIdCargo())
				.map(id -> cargoRepository.getReferenceById(id))
				.orElse(null);				
		Funcionario entity = funcionario.toModel(cargo);
		funcionarioRepository.save(entity);
		return "redirect:/funcionarios";
	}

	@GetMapping("add")
	public String create(Model model) {
		model.addAttribute("funcionario", new FormFuncionario());
		model.addAttribute("lovCargos", listOfValueBuilder.getLovCargos());		
		return "funcionario/form";
	}

	@GetMapping("update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Funcionario funcionario = funcionarioRepository.findById(id).orElse(new Funcionario());

		model.addAttribute("funcionario", new FormFuncionario().toForm(funcionario));
		model.addAttribute("lovCargos", listOfValueBuilder.getLovCargos());		
		
		return "funcionario/form";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable Long id) {
		funcionarioRepository.deleteById(id);
		return "redirect:/funcionarios";
	}
}
