package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class TokenService {

    private static final String CHAVE_LOGIN = "login";
    private final UsuarioService usuarioService;
    @Value("${jwt.secret}")
    private String secret;

    public TokenService(@Lazy UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String gerarToken (UsuarioEntity usuarioEntity) {
        // usuario = login = user  | senha = 123
//        String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha(); // user;123
//        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes()); // dXNlcjsxMjM=

        String token =
                Jwts.builder()
                        .claim(CHAVE_LOGIN, usuarioEntity.getLogin())
                        .claim(Claims.ID, usuarioEntity.getIdUsuario())
                        .setIssuedAt(Date.valueOf(LocalDate.now())) // data de agora
                        .setExpiration(Date.valueOf(LocalDate.now().plusDays(1))) // data de agora + 24hrs
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
        return token;
    }


    public Optional<UsuarioEntity> isValid(String token) {
        if (token == null) {
            return Optional.empty();
        }
//        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
//        String decoded = new String(decodedBytes); // login;senha
//        String[] split = decoded.split(";"); // [0] login [1] senha
//        return usuarioService.findByLoginAndSenha(split[0], split[1]);
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        Integer id = claims.get(Claims.ID, Integer.class);
        return usuarioService.findById(id);
    }
}
