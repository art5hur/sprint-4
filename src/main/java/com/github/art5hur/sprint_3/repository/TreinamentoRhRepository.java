package com.github.art5hur.sprint_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.art5hur.sprint_3.model.TreinamentoRh;

@Repository
public interface TreinamentoRhRepository extends JpaRepository<TreinamentoRh, Long> {
    // Repositório padrão JPA
}
