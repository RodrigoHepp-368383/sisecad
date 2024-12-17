package com.module.sisecad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.sisecad.model.Login;
import com.module.sisecad.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login save(Login login) {
        return loginRepository.save(login);
    }
}