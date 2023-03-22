package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;

@Service
public class TokenService {

    private static final String CHAVE_LOGIN = "login";
    private static final String TOKEN_PREFIX = "Bearer ";
    @Value("${jwt.secret}")
    private String secret;


    public String gerarToken(UsuarioEntity usuarioEntity) {
        String token =
                Jwts.builder()
                        .claim(CHAVE_LOGIN, usuarioEntity.getLogin())
                        .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                        .setIssuedAt(Date.valueOf(LocalDate.now()))
                        .setExpiration(Date.valueOf(LocalDate.now().plusDays(1)))
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
        return token;
    }


    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token != null) {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String user = body.get(Claims.ID, String.class);
            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }
}