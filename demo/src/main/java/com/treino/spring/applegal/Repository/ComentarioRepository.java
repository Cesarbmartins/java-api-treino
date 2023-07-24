package com.treino.spring.applegal.Repository;


import com.treino.spring.applegal.Model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository  extends JpaRepository<Comentario,Long> {
}
