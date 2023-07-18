package com.treino.spring.applegal.Controller;

import com.treino.spring.applegal.Model.Usuario;
import com.treino.spring.applegal.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {

        return usuarioService.cadastrarUsuario(usuario);

    }

  @PutMapping("/editar/{id}")
    public Usuario editarUsuario(@PathVariable Long id,@RequestBody Usuario usuario){
        return usuarioService.editarUsuario(id,usuario);
  }

  @DeleteMapping("/deletar/{id}")
    public void deletarUsuario(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
  }
}
