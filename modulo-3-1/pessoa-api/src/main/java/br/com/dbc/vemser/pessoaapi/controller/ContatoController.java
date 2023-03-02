package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato") // http://localhost:8080/contato
@Validated
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> list() {
        return new ResponseEntity<>(contatoService.lista(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<Contato>> findByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return new ResponseEntity<>(contatoService.findByIdPessoa(idPessoa), HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Contato> create(@PathVariable("idPessoa") Integer idPessoa,
                          @Valid @RequestBody Contato contato) throws Exception {
        return new ResponseEntity<>(contatoService.create(idPessoa, contato) , HttpStatus.CREATED);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody Contato contatoAtualizar) throws Exception {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}