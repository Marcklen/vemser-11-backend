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

    @GetMapping("/{idPessoa}")
    public List<Contato> findByIdPessoa(@PathVariable("idPessoa")Integer idPessoa) {
        return contatoService.findByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa")Integer idPessoa,
                          @RequestBody Contato contato) throws Exception {
        return contatoService.create(idPessoa, contato);
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