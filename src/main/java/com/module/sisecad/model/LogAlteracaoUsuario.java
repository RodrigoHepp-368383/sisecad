package com.module.sisecad.model;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "log_alteracoes_usuarios")
public class LogAlteracaoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Integer usuarioResponsavelId;

    private LocalDateTime dataAlteracao = LocalDateTime.now();

    private String descricao;

    public LogAlteracaoUsuario() {
    }
    
    public LogAlteracaoUsuario(Long id, Usuario usuario, Integer usuarioResponsavelId, LocalDateTime dataAlteracao, String descricao) {
        this.id = id;
        this.usuario = usuario;
        this.usuarioResponsavelId = usuarioResponsavelId;
        this.dataAlteracao = dataAlteracao;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getUsuarioResponsavelId() {
        return usuarioResponsavelId;
    }

    public void setUsuarioResponsavelId(Integer usuarioResponsavelId) {
        this.usuarioResponsavelId = usuarioResponsavelId;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

}