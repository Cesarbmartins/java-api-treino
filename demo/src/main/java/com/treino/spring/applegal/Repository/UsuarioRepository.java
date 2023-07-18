package com.treino.spring.applegal.Repository;

import com.treino.spring.applegal.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
