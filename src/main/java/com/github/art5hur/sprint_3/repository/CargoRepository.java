package com.github.art5hur.sprint_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.art5hur.sprint_3.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
