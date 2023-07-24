package com.treino.spring.applegal.Repository;


import com.treino.spring.applegal.Model.Comentario;
import com.treino.spring.applegal.Model.Obra;
import com.treino.spring.applegal.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository  extends JpaRepository<Comentario,Long> {
    List<Comentario> findByObraId(Long idObra);
    List<Comentario> findByUsuarioAndObra(Usuario usuario, Obra obra);
}
