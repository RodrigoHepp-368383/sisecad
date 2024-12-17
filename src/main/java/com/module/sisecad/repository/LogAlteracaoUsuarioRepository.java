package com.module.sisecad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.sisecad.model.LogAlteracaoUsuario;

public interface LogAlteracaoUsuarioRepository extends JpaRepository<LogAlteracaoUsuario, Long> {
}