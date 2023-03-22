package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;

    public TokenService(@Lazy UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public String gerarToken (UsuarioEntity usuarioEntity) {
        // FIXME por meio do usuário, gerar um token
        // usuario = login = user  | senha = 123
        String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha(); // user;123
        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes()); // dXNlcjsxMjM=
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token) {
        // FIXME validar se o token é válido e retornar o usuário se for válido
        if (token == null) {
            return Optional.empty();
        }
        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes); // login;senha
        String[] split = decoded.split(";"); // [0] login [1] senha
        return usuarioService.findByLoginAndSenha(split[0], split[1]);
    }
}
