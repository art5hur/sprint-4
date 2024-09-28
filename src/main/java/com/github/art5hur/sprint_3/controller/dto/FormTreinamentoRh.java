package com.github.art5hur.sprint_3.controller.dto;

import com.github.art5hur.sprint_3.model.Treinamento;
import com.github.art5hur.sprint_3.model.TreinamentoRh;

public class FormTreinamentoRh {
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

	
	
	public FormTreinamentoRh toForm(TreinamentoRh treinamentoRh) {
        this.id = treinamentoRh.getId();
        this.nome = treinamentoRh.getNome();
        this.descricao = treinamentoRh.getDescricao();
        this.instrutor = treinamentoRh.getInstrutor();
        this.area = treinamentoRh.getArea();
        this.data = treinamentoRh.getData();
        return this;
    }

    public TreinamentoRh toModel() {
        TreinamentoRh treinamentoRh = new TreinamentoRh();
        treinamentoRh.setId(this.id);
        treinamentoRh.setNome(this.nome);
        treinamentoRh.setDescricao(this.descricao);
        treinamentoRh.setInstrutor(this.instrutor);
        treinamentoRh.setArea(this.area);
        treinamentoRh.setData(this.data);
        return treinamentoRh;
    }

    // Método para atualizar os dados de um treinamento existente
    public void updateModel(TreinamentoRh treinamentoRh) {
        treinamentoRh.setNome(this.nome);
        treinamentoRh.setDescricao(this.descricao);
        treinamentoRh.setInstrutor(this.instrutor);
        treinamentoRh.setArea(this.area);
        treinamentoRh.setData(this.data);
    }
}

