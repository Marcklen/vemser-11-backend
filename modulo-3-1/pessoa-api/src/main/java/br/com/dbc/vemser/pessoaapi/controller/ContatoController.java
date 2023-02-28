package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") // http://localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;
    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.lista();
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Contato> findById(@PathVariable("idPessoa")Integer idPessoa) {
        return contatoService.findById(idPessoa);
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}