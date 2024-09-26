package com.github.art5hur.sprint_3.controller.dto;

import java.util.Optional;

import com.github.art5hur.sprint_3.model.Cargo;
import com.github.art5hur.sprint_3.model.Departamento;

public class FormCargo {
	private Long id;
	private String nome;
	private Long idDepartamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public FormCargo toForm(Cargo cargo) {
		this.id = cargo.getId();
		this.nome = cargo.getNome();	
		this.idDepartamento = Optional.ofNullable(cargo.getDepartamento())
				.map(d -> d.getId())
				.orElse(null);		
		return this;
	}

	public Cargo toModel(Departamento departamento) {
		Cargo cargo = new Cargo();
		cargo.setId(this.getId());
		cargo.setNome(this.getNome());
		cargo.setDepartamento(departamento);
		return cargo;
	}

}
