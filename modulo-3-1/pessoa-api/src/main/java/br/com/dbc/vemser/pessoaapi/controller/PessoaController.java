package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa") // http://localhost:8080/pessoa
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // teste para saber se o endpoint está funcionando
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @GetMapping("/{idPessoa}") // GET localhost:8080/pessoa/1
    public Pessoa findById(@PathVariable("idPessoa") Integer id) {
        return pessoaService.findById(id);
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa) {
        return pessoaService.create(pessoa);
    }

    @PutMapping("/{idPessoa}")
    public Pessoa update(@PathVariable("idPessoa") Integer id,
                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }
}