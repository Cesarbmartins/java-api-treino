package com.treino.spring.applegal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.treino.spring.applegal.Model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
