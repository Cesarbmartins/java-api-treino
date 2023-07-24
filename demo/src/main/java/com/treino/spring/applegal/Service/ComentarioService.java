package com.treino.spring.applegal.Service;

import com.treino.spring.applegal.Model.Comentario;
import com.treino.spring.applegal.Repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository){
        this.comentarioRepository = comentarioRepository;
    }

    public Comentario salvarComentario (Long idUsuario, Long idObra, Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    public List<Comentario> listarComentarios(){
        return comentarioRepository.findAll();
    }

   public void deletarComentario(Long id){
        comentarioRepository.deleteById(id);
   }
}
