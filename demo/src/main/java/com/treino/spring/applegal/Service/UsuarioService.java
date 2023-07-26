package com.treino.spring.applegal.Service;
import org.springframework.stereotype.Service;
import com.treino.spring.applegal.Model.Usuario;
import com.treino.spring.applegal.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario cadastrarUsuario(Usuario usuario){

        return usuarioRepository.save(usuario);
    }

    public Usuario editarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        if(usuarioAtualizado.getNome() == null){
            usuarioExistente.setNome(usuarioExistente.getNome());

        }

        if(usuarioAtualizado.getEmail() == null){
            usuarioExistente.setNome(usuarioExistente.getNome());
        }

        if(usuarioAtualizado.getSenha() == null){
            usuarioExistente.setNome(usuarioExistente.getNome());
        }
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setSenha(usuarioAtualizado.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id){

        usuarioRepository.deleteById(id);
    }
}
