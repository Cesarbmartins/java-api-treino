package com.treino.spring.applegal.Controller;

import com.treino.spring.applegal.Model.Comentario;
import com.treino.spring.applegal.Model.Obra;
import com.treino.spring.applegal.Model.Usuario;
import com.treino.spring.applegal.Service.ComentarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/listar/{idObra}")
    public ResponseEntity<List<Comentario>> listarComentariosPorObra(@PathVariable Long idObra){
        List<Comentario> comentarios = comentarioService.listarComentariosPorObra(idObra);
        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }

    @GetMapping("/listarPorUsuarioEObra")
    public ResponseEntity<List<Comentario>> listarPorUsuarioEObra(@PathVariable Usuario usuario,
                                                                  @PathVariable Obra obra){
        List<Comentario> comentarios = comentarioService.listarComentariosPorUsuarioEObra(usuario, obra);
        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Comentario>> listarComentarios(){
        List<Comentario> comentarios = comentarioService.listarComentarios();
        return ResponseEntity.status(HttpStatus.OK).body(comentarios);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarComentario(@PathVariable Long id){
        comentarioService.deletarComentario(id);
        return ResponseEntity.noContent().build();
    }
}
