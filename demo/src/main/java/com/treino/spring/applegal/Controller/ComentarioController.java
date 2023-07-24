package com.treino.spring.applegal.Controller;

import com.treino.spring.applegal.Model.Comentario;
import com.treino.spring.applegal.Service.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    private final ComentarioService comentarioService;

    private ComentarioController(ComentarioService comentarioService){
        this.comentarioService = comentarioService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Comentario> salvarComentario(@RequestBody Comentario comentario,
                                                       @RequestBody Long idUsuario,
                                                       @PathVariable Long idObra){
        Comentario comentarioSalvo = comentarioService.salvarComentario(idUsuario,idObra,comentario);
        return ResponseEntity.status(HttpStatus.CREATED).body(comentarioSalvo);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id){
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}
