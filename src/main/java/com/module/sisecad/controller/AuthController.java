package com.module.sisecad.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.sisecad.DTO.CredenciaisDTO;
import com.module.sisecad.model.Usuario;
import com.module.sisecad.service.UsuarioService;
import com.module.sisecad.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    
    private final UsuarioService usuarioService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioService usuarioService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public String login(@RequestBody CredenciaisDTO loginRequest) {
        // Busca o usuário no banco pelo e-mail
        Usuario usuario = usuarioService.buscarPorEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        // Valida a senha fornecida com a senha armazenada
        if (!passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenhaHash())) {
            throw new RuntimeException("Senha inválida.");
        }

        // Gera o token JWT e retorna
        return jwtUtil.gerarToken(usuario.getEmail());
    }

    @PostMapping("/register")
    public String register(@RequestBody CredenciaisDTO registroRequest) {
        if (usuarioService.buscarPorEmail(registroRequest.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(registroRequest.getEmail());
        novoUsuario.setSenhaHash(registroRequest.getSenha());
        novoUsuario.setAtivo(true);

        usuarioService.salvar(novoUsuario);

        return "Usuário registrado com sucesso!";
    }
}

