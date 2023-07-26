package com.treino.spring.applegal.DTO;

import com.treino.spring.applegal.Model.Obra;
import com.treino.spring.applegal.Model.Usuario;

public class UsuarioObraDTO {

    private Usuario usuario;
    private Obra obra;

    public UsuarioObraDTO(Usuario usuario, Obra obra) {
        this.usuario = usuario;
        this.obra=obra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }
}
