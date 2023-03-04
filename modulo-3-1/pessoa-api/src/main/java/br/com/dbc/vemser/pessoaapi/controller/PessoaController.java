package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // http://localhost:8080/pessoa
@Validated
@Slf4j
public class PessoaController {

    private final PessoaService pessoaService;
    private final PropertieReader propertieReader;

    public PessoaController(PessoaService pessoaService, PropertieReader propertieReader) {
        this.pessoaService = pessoaService;
        this.propertieReader = propertieReader;
    }

    // teste para saber se o endpoint está funcionando
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/ambiente")
    public String ambiente() {
        return "Estou no ambiente: '" + propertieReader.getPropertie() + "'";
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<Pessoa>> listByName(@RequestParam("nome") String nome) throws Exception {
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) throws Exception {

        log.info("Pessoa criando.." + pessoa);
        PessoaDTO p = pessoaService.create(pessoa);
        log.info("Pessoa criada!" + p);

        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        log.info("Atualizando pessoa: " + pessoaAtualizar);
        Pessoa update = pessoaService.update(id, pessoaAtualizar);
        log.info("Pessoa atualizada: " + update);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Deletando pessoa com id : " + id);
        pessoaService.delete(id);
        log.info("Pessoa deletada com sucesso");
        return ResponseEntity.ok().build();
    }
}