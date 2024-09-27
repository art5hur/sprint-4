package com.github.art5hur.sprint_3.controller.dto;

import com.github.art5hur.sprint_3.model.Treinamento;

public class FormTreinamento {
    private Long id;
    private String nome;
    private String descricao;
    private String area;
    private String instrutor;
    private String data;

    

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	public FormTreinamento toForm(Treinamento treinamento) {
        this.id = treinamento.getId();
        this.nome = treinamento.getNome();
        this.descricao = treinamento.getDescricao();
        this.instrutor = treinamento.getInstrutor();
        this.area = treinamento.getArea();
        this.data = treinamento.getData();
        return this;
    }

    public Treinamento toModel() {
        Treinamento treinamento = new Treinamento();
        treinamento.setId(this.id);
        treinamento.setNome(this.nome);
        treinamento.setDescricao(this.descricao);
        treinamento.setInstrutor(this.instrutor);
        treinamento.setArea(this.area);
        treinamento.setData(this.data);
        return treinamento;
    }

    // Método para atualizar os dados de um treinamento existente
    public void updateModel(Treinamento treinamento) {
        treinamento.setNome(this.nome);
        treinamento.setDescricao(this.descricao);
        treinamento.setInstrutor(this.instrutor);
        treinamento.setArea(this.area);
        treinamento.setData(this.data);
    }
}

