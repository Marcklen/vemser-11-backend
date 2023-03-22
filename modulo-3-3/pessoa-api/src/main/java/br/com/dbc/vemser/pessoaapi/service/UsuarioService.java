package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.in.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.out.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.out.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final ObjectMapper objectMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public UsuarioService(UsuarioRepository usuarioRepository,
                          TokenService tokenService,
                          ObjectMapper objectMapper,
                          @Lazy AuthenticationManager authenticationManager,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tokenService = tokenService;
        this.objectMapper = objectMapper;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<UsuarioEntity> findByLogin(String username) {
        return usuarioRepository.findByLogin(username);
    }

    public String autenticar(LoginDTO loginDTO) throws RegraDeNegocioException {
        try {
            UsernamePasswordAuthenticationToken passwordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getLogin(),
                            loginDTO.getSenha()
                    );

            Authentication authentication =
                    authenticationManager.authenticate(passwordAuthenticationToken);

            Object principal = authentication.getPrincipal();
            UsuarioEntity usuarioEntity = (UsuarioEntity) principal;

            return tokenService.gerarToken(usuarioEntity);
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("Credenciais inválidas!");
        }
    }

    public UsuarioDTO salvar(UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        if (findByLogin(usuarioCreateDTO.getLogin()).isPresent()) {
            throw new RegraDeNegocioException("Login já cadastrado!");
        }
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        usuarioEntity.setSenha(passwordEncoder.encode(usuarioCreateDTO.getSenha()));
        usuarioEntity = usuarioRepository.save(usuarioEntity);
        return objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
    }
}