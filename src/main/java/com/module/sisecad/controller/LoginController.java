package com.module.sisecad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.sisecad.model.Login;
import com.module.sisecad.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        return ResponseEntity.ok(loginService.save(login));
    }
}