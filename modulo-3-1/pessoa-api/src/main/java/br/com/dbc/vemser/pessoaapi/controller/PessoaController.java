package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // http://localhost:8080/pessoa
@Validated
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
        return "Estou no ambiente: '"+propertieReader.getPropertie() + "'";
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<Pessoa>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<Pessoa>> listByName(@RequestParam("nome") String nome) throws Exception{
        return new ResponseEntity<>(pessoaService.listByName(nome), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) throws Exception{
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.CREATED);
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return new ResponseEntity<>(pessoaService.update(id, pessoaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}