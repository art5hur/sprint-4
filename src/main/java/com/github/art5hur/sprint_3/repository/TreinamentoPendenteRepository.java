package com.github.art5hur.sprint_3.repository;


import com.github.art5hur.sprint_3.model.TreinamentoPendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinamentoPendenteRepository extends JpaRepository<TreinamentoPendente, Long> {
}
