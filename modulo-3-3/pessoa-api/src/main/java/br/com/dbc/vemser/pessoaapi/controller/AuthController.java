package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.in.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.out.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.out.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO loginDTO) throws RegraDeNegocioException {
        String token = usuarioService.autenticar(loginDTO);
        return token;
    }

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<UsuarioDTO> create(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        UsuarioDTO usuario = usuarioService.salvar(usuarioCreateDTO);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/usuario")
    public ResponseEntity<UsuarioDTO> getUsuario() throws RegraDeNegocioException {
        UsuarioDTO usuario = usuarioService.getLoggedUser();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
}
