package com.module.sisecad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.sisecad.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
