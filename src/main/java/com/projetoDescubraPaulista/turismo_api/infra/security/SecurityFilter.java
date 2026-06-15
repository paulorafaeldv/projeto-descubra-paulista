package com.projetoDescubraPaulista.turismo_api.infra.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.projetoDescubraPaulista.turismo_api.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 1. Recupera o token do header Authorization
        var token = this.recoverToken(request);
        
        if (token != null) {
            // 2. Valida o token e recupera o e-mail (subject)
            var email = tokenService.validarToken(token);
            
            if (email != null && !email.isEmpty()) {
                // 3. Busca o usuário no banco de dados
                var userOptional = usuarioRepository.findByEmail(email);
                
                if (userOptional.isPresent()) {
                    var user = userOptional.get();
                    
                    // 4. Cria as autoridades (roles) do usuário
                    var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
                    
                    // 5. Cria o objeto de autenticação do Spring Security
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
                    
                    // 6. Define a autenticação no contexto do Spring Security
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    
                    System.out.println(">>> SUCESSO: Usuário " + email + " autenticado!");
                } else {
                    System.out.println(">>> ERRO: Usuário não encontrado no banco: " + email);
                }
            } else {
                System.out.println(">>> ERRO: Token inválido ou expirado.");
            }
        } else {
            System.out.println(">>> AVISO: Nenhuma requisição com Bearer token encontrada.");
        }
        
        // 7. Continua o fluxo da requisição
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "").trim();
        }
        return null;
    }
}