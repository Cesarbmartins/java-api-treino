package com.treino.spring.applegal.Service;

import com.treino.spring.applegal.Model.Comentario;
import com.treino.spring.applegal.Model.Obra;
import com.treino.spring.applegal.Model.Usuario;
import com.treino.spring.applegal.Repository.ComentarioRepository;
import com.treino.spring.applegal.Repository.ObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final UsuarioService usuarioService;
    private final ObraService obraService;
    private final ObraRepository obraRepository;
    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository,
                             UsuarioService usuarioService,
                             ObraService obraService,
                             ObraRepository obraRepository){
        this.comentarioRepository = comentarioRepository;
        this.usuarioService = usuarioService;
        this.obraService = obraService;
        this.obraRepository = obraRepository;
    }

    public Comentario salvarComentario(Long idUsuario, Long idObra, Comentario comentario) {
        Usuario usuario = usuarioService.buscarUsuario(idUsuario);
        Obra obra = obraService.acharObraPorId(idObra);

        comentario.setUsuario(usuario);
        comentario.setObra(obra);
        comentario.setData(new Date());

        Comentario comentarioSalvo = comentarioRepository.save(comentario);

        if (obra != null) {
            Double novaMedia = calcularMediaAvaliacao(obra);
            obra.setMedia_avaliacao(novaMedia);
            obraRepository.save(obra);
        }

        return comentarioSalvo;
    }


    public Double calcularMediaAvaliacao(Obra obra) {
        List<Comentario> comentarios = obra.getComentarios();
        if (comentarios.isEmpty()) {
            return 0.0;
        }

        Double somaNotas = 0.0;
        for (Comentario comentario : comentarios) {
            somaNotas += comentario.getNota();
        }

        return somaNotas / comentarios.size();
    }

    public List<Comentario> listarComentariosPorObra(Long idObra) {
        return comentarioRepository.findByObraId(idObra);
    }

    public List<Comentario> listarComentarios() {
        return comentarioRepository.findAll();
    }

    public List<Comentario> listarComentariosPorUsuarioEObra(Usuario usuario,
                                                             Obra obra) {
        return comentarioRepository.findByUsuarioAndObra(usuario, obra);
    }
    public void deletarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    public Comentario buscarComentario(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }


}
