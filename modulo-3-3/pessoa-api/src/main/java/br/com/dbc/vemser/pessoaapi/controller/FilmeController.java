package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.in.FilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.out.FilmeDTO;
import br.com.dbc.vemser.pessoaapi.dto.in.PessoaFilmeCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.out.PessoaFilmeDTO;
import br.com.dbc.vemser.pessoaapi.service.FilmeService;
import br.com.dbc.vemser.pessoaapi.service.PessoaFilmeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes") // http://localhost:8080/filmes
@Validated
@Slf4j
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;
    private final PessoaFilmeService pessoaFilmeService;

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<FilmeDTO>> list() {
        return new ResponseEntity<>(filmeService.listarFilmes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> criar(@Valid @RequestBody FilmeCreateDTO filmeCreateDto) {
        log.info("Solicitando requisição para criar filme.." + filmeCreateDto);
        FilmeDTO filme = filmeService.criarFilme(filmeCreateDto);
        return new ResponseEntity<>(filme, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> editar(@PathVariable Integer id, @Valid @RequestBody FilmeCreateDTO filmeCreateDto) throws Exception {
        log.info("Solicitando requisição para editar filme.." + filmeCreateDto);
        FilmeDTO filme = filmeService.editarFilme(id, filmeCreateDto);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) throws Exception {
        log.info("Solicitando requisição para excluir filme.." + id);
        filmeService.excluirFilme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/avaliar-filme/{idUsuario}")
    public ResponseEntity<PessoaFilmeDTO> avaliarFilme(@PathVariable Integer idUsuario,
                                                       @Valid @RequestBody PessoaFilmeCreateDTO pessoaFilmeCreateDTO) throws Exception {
        log.info("Solicitando requisição para avaliar filme.." + pessoaFilmeCreateDTO);
        PessoaFilmeDTO pessoaFilmeDTO = pessoaFilmeService.avaliarFilme(idUsuario, pessoaFilmeCreateDTO);
        return new ResponseEntity<>(pessoaFilmeDTO, HttpStatus.CREATED);
    }
}