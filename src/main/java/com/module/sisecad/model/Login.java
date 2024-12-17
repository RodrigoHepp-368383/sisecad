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
@Table(name = "logins")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String ip;

    private LocalDateTime dataLogin = LocalDateTime.now();

    private Boolean sucesso = true;

    public Login() {
    }

    public Login(Long id, Usuario usuario, String ip, LocalDateTime dataLogin, Boolean sucesso) {
        this.id = id;
        this.usuario = usuario;
        this.ip = ip;
        this.dataLogin = dataLogin;
        this.sucesso = sucesso;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(LocalDateTime dataLogin) {
        this.dataLogin = dataLogin;
    }

    public Boolean getSucesso() {
        return sucesso;
    }

    public void setSucesso(Boolean sucesso) {
        this.sucesso = sucesso;
    }

}