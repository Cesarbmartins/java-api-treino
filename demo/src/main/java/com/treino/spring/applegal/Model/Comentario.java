package com.treino.spring.applegal.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String texto;

    @Column()
    private Date data;

    @Column()
    private Double nota;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_obra")
    private Obra obra;

    public Comentario() {
        
    }

    public Comentario(Double nota){
        this.nota = nota;
    }
    public Comentario(String texto, Date data, Double nota, Usuario usuario, Obra obra) {
        this.texto = texto;
        this.data = data;
        this.usuario = usuario;
        this.obra = obra;
        this.nota = nota;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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
