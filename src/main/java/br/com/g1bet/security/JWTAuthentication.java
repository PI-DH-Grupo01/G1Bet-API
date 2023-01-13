package br.com.g1bet.security;

import br.com.g1bet.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JWTAuthentication extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    private static final long EXPIRATION = 600000;

    private static final String senha = "APOSTAS G1BET";

    public JWTAuthentication(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // busca as credenciais digitadas pelo usuário
        Usuario usuario = null;
        try {
            usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(
                usuario.getEmail(),
                usuario.getSenha()
        );

        return authenticationManager.authenticate(authResult);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        String username = ((UserDetails) authResult.getPrincipal()).getUsername();

        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION))
                .sign(Algorithm.HMAC512(senha.getBytes()));

        String headerBody = username + " " + token;

        response.setHeader(HttpHeaders.AUTHORIZATION , headerBody);
    }
}