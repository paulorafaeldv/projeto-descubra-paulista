package com.projetoDescubraPaulista.turismo_api.controller;

import com.projetoDescubraPaulista.turismo_api.dto.LoginRequestDTO;
import com.projetoDescubraPaulista.turismo_api.dto.LoginResponseDTO;
import com.projetoDescubraPaulista.turismo_api.dto.RegisterRequestDTO;
import com.projetoDescubraPaulista.turismo_api.infra.security.TokenService;
import com.projetoDescubraPaulista.turismo_api.models.Usuario;
import com.projetoDescubraPaulista.turismo_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDTO data) {
        this.authService.registrar(data);
        return ResponseEntity.ok().build();
    }
}
