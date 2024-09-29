package com.github.art5hur.sprint_3.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TreinamentoPendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treinamento_id")
    private Treinamento treinamento;

    private int progresso; // Progresso do treinamento

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Treinamento getTreinamento() {
        return treinamento;
    }

    public void setTreinamento(Treinamento treinamento) {
        this.treinamento = treinamento;
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = progresso;
    }
}
