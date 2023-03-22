package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.out.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    // FIXME construir métodoss necessários para o usuário
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public String autenticar(LoginDTO loginDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> existeUsuario = findByLoginAndSenha(loginDTO.getLogin(), loginDTO.getSenha());
        if (existeUsuario.isPresent()) {
            return tokenService.gerarToken(existeUsuario.get());
        } else {
            throw new RegraDeNegocioException("Quem é tu maluco ? Não te conheço !");
        }
    }
}
